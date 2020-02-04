package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * programmers.dp[n][m] = n자리 수에서 마지막 숫자가 m일 때의 경우의 수
 */
public class BOJ_11057_오르막수 {
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[n+1][10];
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if(n==1)
            return 10;

        for(int i=0;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<=9;j++){ //마지막 수를 j로 두고
                for(int k=0;k<=j;k++) { // j보다 같거나 작은 수까지를 구해서 더해준다
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        int sum = 0;
        for(int i=0;i<=9;i++)
            sum += dp[n][i];

        return sum%10007;
    }
}
