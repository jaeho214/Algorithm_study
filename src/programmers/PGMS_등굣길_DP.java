package programmers;

public class PGMS_등굣길_DP {
    public static void main(String[] args) {
        PGMS_등굣길_DP pgms_등굣길DP = new PGMS_등굣길_DP();
        int[][] puddles = {{1,2},{2,1}};
        System.out.println(pgms_등굣길DP.solution(4,3,puddles));
    }
    public int solution(int m, int n, int[][] puddles) {

        int[][] dp = new int[n+1][m+1];
        for(int[] puddle : puddles)
            dp[puddle[1]][puddle[0]] = Integer.MIN_VALUE;

        dp[1][1] = 1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if((i==1 && j==1) || dp[i][j] == Integer.MIN_VALUE) continue;

                if(dp[i-1][j] == Integer.MIN_VALUE && dp[i][j-1] == Integer.MIN_VALUE)
                    dp[i][j] = 0;
                else if(dp[i-1][j] == Integer.MIN_VALUE)
                    dp[i][j] = dp[i][j-1] % 1000000007;
                else if(dp[i][j-1] == Integer.MIN_VALUE)
                    dp[i][j] = dp[i-1][j] % 1000000007;
                else
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        return dp[n][m] == Integer.MIN_VALUE ? 0 : dp[n][m] % 1000000007;
    }
}
