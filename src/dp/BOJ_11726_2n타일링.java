package dp;

import java.util.Scanner;

public class BOJ_11726_2n타일링 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1];
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        if(dp[n] > 0)
            return dp[n];

        dp[n] = solve(n-1) + solve(n-2);

        return dp[n]%10007;
    }
}
