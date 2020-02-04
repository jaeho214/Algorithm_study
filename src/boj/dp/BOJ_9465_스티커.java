package boj.dp;

import java.util.Scanner;
/*
 * programmers.dp[i][j] => i열 j행까지의 최대값
 * 바로 전 대각선과 그 전 대각선의 값을 비교하였다
 * 왜냐면 모든 행의 값을 더해주는 건 아니기 때문
 */
public class BOJ_9465_스티커 {
    static int a[][];
    static int dp[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            a = new int[4][n+1];
            dp = new int[4][n+1];
            for(int j=1;j<=2;j++){
                for(int k=1;k<=n;k++) {
                    a[j][k] = sc.nextInt();
                }
            }
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        if(n==1)
            return Math.max(a[1][1], a[2][1]);

        dp[1][1] = a[1][1];
        dp[2][1] = a[2][1];
        int max = 0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<=2;j++){
                dp[j][i] = Math.max(dp[j+1][i-1], dp[j-1][i-1]) + a[j][i]; //바로 전 대각선을 더해주는 경우와
                dp[j][i] = Math.max(Math.max(dp[j+1][i-2], dp[j-1][i-2]) + a[j][i], dp[j][i]); // 바로 전 대각선을 더해주지 않는 경우

                if(max < dp[j][i])
                    max = dp[j][i];
            }
        }

        return max;
    }
}
