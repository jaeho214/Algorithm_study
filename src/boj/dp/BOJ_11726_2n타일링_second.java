package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2n타일링_second {
    public static void main(String[] args) throws IOException {
        System.out.println(solve(input()));
    }

    private static int solve(int n) {
        int dp[] = new int[1001];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        return dp[n];
    }

    public static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return Integer.parseInt(br.readLine());
    }
}
