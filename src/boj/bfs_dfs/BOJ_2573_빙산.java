package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://bcp0109.tistory.com/11
 * 생각한 건 다 똑같았는데 시간초과가 날까봐 막 해보지 못했다
 * 1. 먼저 dfs를 통해 덩어리의 개수를 센다
 * 2. 덩어리의 개수에 따라 결과를 내거나 빙산을 녹인다
 * 3. 빙산을 녹이고 나서 다시 덩어리 개수를 센다.
 */
public class BOJ_2573_빙산 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int[][] arr, cnt;
    static boolean visited[][];
    static int n,m;

    public static void main(String[] args) throws IOException {
        input();
        int year = 0;
        while(true){
            int count = 0;
            for(int i=1;i<=n;i++){
                for(int j=1;j<=m;j++){
                    if(!visited[i][j] && arr[i][j] != 0){
                        dfs(i,j);
                        count++;
                    }
                }
            }
            //다 녹을 때까지 덩어리가 안나눠지면
            if(count == 0){
                System.out.println(0);
                break;
            //분리가 되었으면
            }else if(count >= 2){
                //몇년이 지났는지 출력
                System.out.println(year);
                break;
            }

            //덩어리 카운트 후 덩어리가 하나면 빙산 녹이기
            melting();
            //연도 카운트
            year++;
        }
    }

    private static void melting() {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //빙산을 녹이고
                arr[i][j] -= cnt[i][j];

                //0보다 작아지면 0으로 초기화
                if(arr[i][j] < 0)
                    arr[i][j] = 0;

                //방문 여부와 주변 바닷물 수를 다시 초기화
                visited[i][j] = false;
                cnt[i][j] = 0;
            }
        }
    }

    //dfs에서 덩어리 개수를 카운트하면서 주변이 0인 위치까지 같이 카운트했으면 되었는데
    //자꾸 주변 카운트는 bfs를 하려고 해서 오래걸렸다.
    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=1 && nx<=n && ny >=1 && ny <=m){
                //주변이 바닷물인 위치 카운트
                if(arr[nx][ny] == 0){
                    cnt[x][y]++;
                }
                if(!visited[nx][ny] && arr[nx][ny] != 0) {
                    dfs(nx, ny);
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        cnt = new int[n+1][m+1];
        visited = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        br.close();
    }
}
