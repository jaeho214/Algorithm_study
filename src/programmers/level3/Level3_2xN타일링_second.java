package programmers.level3;

public class Level3_2xN타일링_second {
    public static void main(String[] args) {
        Level3_2xN타일링_second level3_2xN타일링_second = new Level3_2xN타일링_second();
        System.out.println(level3_2xN타일링_second.solution(4));
    }
    public int solution(int n) {
        dp = new int[n+1];
        return topDown(n);

    }

    private int[] dp;
    public int bottomUp(int n){

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }

    public int topDown(int n){
        if(n == 1) {
            dp[n] = 1;
            return 1;
        }
        if(n == 2) {
            dp[n] = 2;
            return 2;
        }
        if(dp[n] > 0)
            return dp[n];

        dp[n] = (topDown(n-1) + topDown(n-2)) % 1000000007;

        return dp[n];
    }
}
