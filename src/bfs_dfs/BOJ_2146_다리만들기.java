package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * https://github.com/hotehrud/acmicpc/blob/master/algorithm/graph/2146.java
 */
public class BOJ_2146_다리만들기 {
    static class Pair {
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, -1, 0, 1};
    static int n;
    static int[][] arr, dist;
    static boolean visited[][];
    static Queue<Pair> q = new LinkedList<>();
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        //먼저 섬마다 번호를 매겨준다.
        int cnt = 1;
        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= n; j++) {
                if (arr[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j, cnt);
                    cnt++;
                }
            }
        }

        //모든 배열을 돌면서
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                //육지일 경우에
                if(arr[i][j] != 0){
                    //육지 배열을 모두 큐에 넣어준다
                    q.add(new Pair(i,j));
                }
            }
        }

        bfs();

        //모든 다리들을 리스트에 넣어주고
        int ans = Integer.MAX_VALUE;
        //다리 후보들 중에서 제일 짧은 다리를 출력
        for(int v : list){
            if(ans > v){
                ans = v;
            }
        }
        System.out.println(ans);
    }

    private static void bfs() {
        while(!q.isEmpty()){
            int x = q.peek().x;
            int y = q.peek().y;
            q.poll();

            //육지의 상하좌우를 돌면서
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 1 && nx <= n && ny >= 1 && ny <= n) {
                    //육지이고 현재 육지와 다른 번호의 육지라면
                    //다른 섬과 연결이 된 것이다.
                    if (arr[nx][ny] != 0 && arr[nx][ny] != arr[x][y]) {
                        //다른 섬과 연결이 되었다면 다리의 길이를 리스트에 저장
                        //서로 다른 육지에서 계속 뻗어져 나오므로 두 다른 육지로부터 나온 다리길이의 합을 구함
                        list.add(dist[nx][ny] + dist[x][y]);
                    }
                    //바다라면
                    if (arr[nx][ny] == 0) {
                        //육지로 만들기위해 큐에 저장
                        q.add(new Pair(nx, ny));

                        //같은 번호의 육지로 만들고
                        arr[nx][ny] = arr[x][y];
                        //거리를 더해준다
                        dist[nx][ny] = dist[x][y] + 1;
                    }

                }
            }
        }
    }

    private static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        arr[x][y] = cnt;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 1 && nx <= n && ny >= 1 && ny <= n){
                if(arr[nx][ny] == 1 && !visited[nx][ny]){
                    dfs(nx,ny, cnt);
                }
            }
        }

    }

    private static void input () throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        visited = new boolean[n + 1][n + 1];
        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
