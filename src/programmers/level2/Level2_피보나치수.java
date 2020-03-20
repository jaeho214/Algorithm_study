package programmers.level2;

public class Level2_피보나치수 {
    public static void main(String[] args) {
        Level2_피보나치수 level2_피보나치수 = new Level2_피보나치수();
        System.out.println(level2_피보나치수.solution(5));
    }

    public int solution(int n) {
        int[] dp = new int[n+1];

        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n] % 1234567;
    }
}
