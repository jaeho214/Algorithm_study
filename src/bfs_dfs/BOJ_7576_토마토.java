package bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7576_토마토 {
    private static boolean visited[][];
    private static int a[][];
    private static int n,m;
    private static int dx[] = {0,1,0,-1};
    private static int dy[] = {1,0,-1,0};
    static Queue<Integer> qx;
    static Queue<Integer> qy;

    public static void main(String[] args) {
        input();
        //출발지 큐에서 하나를 꺼내서 시작한다.
        int result = solve(qx.peek(),qx.peek());
        output(result);
    }

    private static void output(int result) {
        try{
            String str = String.valueOf(result);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(str);
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static int solve(int x, int y) {
        while(!qx.isEmpty() && !qy.isEmpty()) {
            x = qx.poll();
            y = qy.poll();
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if (nextX > 0 && nextY > 0 && nextX <= n && nextY <= m) {
                    if (a[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        qx.add(nextX);
                        qy.add(nextY);
                        visited[nextX][nextY] = true;
                        a[nextX][nextY] = a[x][y] + 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i][j] == 0){
                    return -1;
                }else {
                    max = Math.max(a[i][j], max);
                }
            }
        }

        return max-1;

    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            a = new int[n+1][m+1];
            visited = new boolean[n+1][m+1];
            qx = new LinkedList<>();
            qy = new LinkedList<>();

            for(int i=1;i<=n;i++){
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
                for(int j=1;j<=m;j++){
                    a[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                    if(a[i][j] == 1){
                        //출발 지점을 미리 큐에 넣어놓음
                        qx.add(i);
                        qy.add(j);
                    }
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
