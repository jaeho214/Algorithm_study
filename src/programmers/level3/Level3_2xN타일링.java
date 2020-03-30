package programmers.level3;

public class Level3_2xN타일링 {
    public static void main(String[] args) {
        Level3_2xN타일링 level3_2xN타일링 = new Level3_2xN타일링();
        System.out.println(level3_2xN타일링.solution(4));
    }

    public int solution(int n) {
        int dp[] = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
