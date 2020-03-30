package programmers.level3;

public class Level3_타일장식물 {
    public static void main(String[] args) {
        Level3_타일장식물 level3_타일장식물 = new Level3_타일장식물();
        System.out.println(level3_타일장식물.solution(6));
    }

    long dp[];
    public long solution(int N) {
        dp = new long[N+1];

        recursion(N);

        return 2*dp[N] + 2*(dp[N]+dp[N-1]);
    }

    private long recursion(int n){
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        if(dp[n] > 0)
            return dp[n];

        dp[n] = recursion(n-1) + recursion(n-2);

        return dp[n];
    }
}
