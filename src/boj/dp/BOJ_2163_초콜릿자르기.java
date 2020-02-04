package boj.dp;

import java.util.Scanner;
/*
 * 초콜릿을 자르는 횟수는
 * 2x3 초콜릿의 경우 2 라인을 자르고 2개로 나눠진 1x3짜리 초콜릿을 잘라야 한다.(순서 바뀌어도 무관)
 * 점화식 : d[n][m] = d[n][1] + n * d[1][m];
 */
public class BOJ_2163_초콜릿자르기 {
    static int[][] dp; //1x1 초콜릿 index 개를 자르는 횟수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        dp = new int[n+1][m+1];
        System.out.println(solve(n,m));
    }

    private static int solve(int n, int m) {
        if(n == 1)
            return m-1;
        if(m == 1)
            return n-1;

        for(int i=1;i<=n;i++){
            dp[i][1] = i-1;
        }
        for(int i=1;i<=m;i++) {
            dp[1][i] = i - 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {
                dp[i][j] = dp[i][1] + (i * dp[1][j]); //i 개를 자르는 대로 자르고 i개로 나뉘어진 1xj의 초콜릿을 다시 나눔
            }
        }

        return dp[n][m];
    }
}
