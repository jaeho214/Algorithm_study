package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_14502_연구소 {
    private static final int BLANK = 0;
    private static final int WALL = 1;
    private static final int VIRUS = 2;
    private static boolean visited[][];
    private static int map[][];
    private static int backUp[][];
    private static int n,m;
    private static int dx[] = {1,0,-1,0};
    private static int dy[] = {0,1,0,-1};
    private static int ret=0;

    public static void main(String[] args) {
        input();
        dfs(0,1,1);
        System.out.println(ret);
    }

    //일단 벽을 세워보는 dfs
    private static void dfs(int cnt, int x, int y) {
        if(cnt == 3){
            //벽을 세개를 세우면 가스를 채워보고 카운트하기
            bfs();
            return;
        }
        for(int i=x;i<=n;i++){
            for(int j=y;j<=m;j++){
                if(map[i][j] == BLANK){
                    //일단 벽을 세워보고
                    map[i][j] = WALL;
                    //카운트를 하고 그 다음부터 다시 벽세우기
                    dfs(cnt + 1, i, j);
                    map[i][j] = BLANK;
                }
            }
            y = 1;
        }
    }

    //가스 채우기 bfs
    private static void bfs() {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        //bfs는 계속 반복되는거라 여기서 초기화 해야하는데 다른 곳에서 초기화해서 오래걸림
        backUp = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //가스를 채울 곳을 백업해두고
                backUp[i][j] = map[i][j];
                //백업해둔곳에서 바이러스면 큐에 넣기
                if(backUp[i][j] == VIRUS){
                    qx.add(i);
                    qy.add(j);
                    visited[i][j] = true;
                }
            }
        }

        while(!qx.isEmpty() && !qy.isEmpty()){
            int x = qx.poll();
            int y = qy.poll();
            //큐에 들어온 좌표를 다 바이러스로 채우기
            backUp[x][y] = VIRUS;

            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 1 && nextX <= n && nextY >= 1 && nextY <= m) {
                    //0인 상황이면 다 바이러스로 채우기
                    if (!visited[nextX][nextY] && backUp[nextX][nextY] == BLANK) {
                        visited[nextX][nextY] = true;
                        qx.add(nextX);
                        qy.add(nextY);
                    }
                }
            }
        }

        int candi = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(backUp[i][j] == BLANK)
                    candi++;
            }
        }
        //계속 반복해서 공간이 제일 많은 것을 탐색
        ret = Math.max(candi, ret);
    }


    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n+1][m+1];
            for(int i=1;i<=n;i++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                for(int j=1;j<=m;j++){
                    map[i][j] = Integer.parseInt(st2.nextToken());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
