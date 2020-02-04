package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 1520 내리막길 문제와 같은 방식으로 풀었다.
 * programmers.dp[x][y] = (x,y) 지점일 때 존재하는 경로의 수
 */
public class BOJ_1890_점프 {
    static int n;
    static int[][] a;
    // 조건을 제대로 못보고 int로 했다가 틀림, long으로 바꿔주고 성공
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        a = new int[n+1][n+1];
        dp = new long[n+1][n+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(1,1));
    }

    private static long solve(int x, int y) {
        if(x==n && y==n) {
            return 1;
        }
        if(dp[x][y] == -1){
            dp[x][y] = 0;
            //현재위치에서 x값이 a[x][y]만큼 아래로 이동하여도 n 보다 작을때
            if(x>=1 && x+a[x][y] <= n){
                //아래로 이동
                dp[x][y] += solve(x+a[x][y], y);
            }
            //현재위치에서 y값이 a[x][y]만큼 오른쪽으로 이동하여도 n보다 작을때
            if(y>=1 && y+a[x][y] <= n){
                //오른쪽으로 이동
                dp[x][y] += solve(x, y+a[x][y]);
            }
        }

        return dp[x][y];
    }
}
