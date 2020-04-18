package programmers.level3;

public class Level3_멀리뛰기 {
    public static void main(String[] args) {
        Level3_멀리뛰기 level3_멀리뛰기 = new Level3_멀리뛰기();
        System.out.println(level3_멀리뛰기.solution(4));
    }

    public long solution(int n) {
        long dp[] = new long[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        return dp[n] % 12345671;
    }
}
