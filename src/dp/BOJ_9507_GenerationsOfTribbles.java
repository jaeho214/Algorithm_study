package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9507_GenerationsOfTribbles {
    private static long dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n = Integer.parseInt(br.readLine());
            dp = new long[n+1];
            System.out.println(solve(n));
        }
    }

    private static long solve(int n) {
        if(n<2)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        if(dp[n]>0)
            return dp[n];

        dp[n] = solve(n-1) + solve(n-2) + solve(n-3) + solve(n-4);

        return dp[n];
    }
}
