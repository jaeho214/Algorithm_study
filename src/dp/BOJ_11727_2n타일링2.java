package dp;

import java.util.Scanner;

public class BOJ_11727_2n타일링2 {
    static int dp[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 3;
        if(dp[n]>0)
            return dp[n];

        dp[1] = 1;
        dp[2] = 3;

        dp[n] = solve(n-1) + 2 * solve(n-2) % 10007;

        return dp[n]% 10007;
    }
}
