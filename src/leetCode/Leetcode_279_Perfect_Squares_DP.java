package leetCode;

import java.util.Arrays;

public class Leetcode_279_Perfect_Squares_DP {
    public static void main(String[] args) {
        Leetcode_279_Perfect_Squares_DP perfect_squares = new Leetcode_279_Perfect_Squares_DP();
        System.out.println(perfect_squares.numSquares(6603));
    }

    public int numSquares(int n) {
        if(n==1) return 1;

        int dp[] = new int[n+1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3;i<=n;i++){
            for(int j=1;j*j<=i;j++) {
                dp[i] = Math.min(dp[i - j*j] + 1, dp[i]);
            }
        }

        return dp[n];
    }
}
