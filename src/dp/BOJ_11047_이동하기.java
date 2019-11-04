package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp[n][m] = n 행 m 열까지 갔을 때의 최대값
 */
public class BOJ_11047_이동하기 {
    static int a[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                a[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        System.out.println(solve(n, m));
    }

    private static int solve(int n, int m) {

        dp[1][1] = a[1][1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]); // 왼쪽 대각선 위와 바로 위를 비교
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1])+a[i][j]; // 비교한 것들 중 큰 값과 왼쪽값을 비교한 후 배열 값을 더해줌
            }
        }

        return dp[n][m];
    }
}
