package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * dp[n] = dp[n-1] + dp[n-2]
 * n-1 에 1을 추가하는 경우와 n-2에 00을 추가하는 경우의 합
 */
public class BOJ_1904_01타일 {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        return dp[n];
    }
}
