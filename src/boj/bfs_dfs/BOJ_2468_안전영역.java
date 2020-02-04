package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2468_안전영역 {
    private static int n, min=101, max=0;
    private static int a[][];
    private static int result[][];
    private static boolean visited[][];
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};

    //배열이 침수되는 함수
    private static void water(int num){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(a[i][j] <= num)
                    result[i][j] = 1;
            }
        }
    }
    private static void input(){
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = new int[n+1][n+1];
            result = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                    min = Math.min(a[i][j], min);
                    max = Math.max(a[i][j], max);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        input();
        // 모두 높이가 1인경우 비가 오지 않았을 때 안전지대 1개
        if(max == 1){
            System.out.println("1");
            return ;
        }
        int res = 0;

        //높이값 중 제일 작은 값부터 침수를 시작
        for(int i=min;i<=max;i++) {
            int count = 0;
            water(i);
            visited = new boolean[n+1][n+1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (!visited[j][k] && result[j][k] == 0) {
                        count++;
                        dfs(j,k);
                    }
                }
            }
            res = Math.max(count,res);
        }

        System.out.println(res);
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 1 && nextY >= 1 && nextX <=n && nextY <=n){
                if( !visited[nextX][nextY] && result[nextX][nextY] == 0 ){
                    dfs(nextX,nextY);
                }
            }
        }
    }
}
