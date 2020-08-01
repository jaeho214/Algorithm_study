package programmers.level3;

public class Level3_멀리뛰기_second {
    public static void main(String[] args) {
        Level3_멀리뛰기_second level3_멀리뛰기_second = new Level3_멀리뛰기_second();
        System.out.println(level3_멀리뛰기_second.solution(5));
    }
    public long solution(int n) {

        if(n==1)
            return 1;
        long dp[] = new long[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-2] + dp[i-1]) % 1234567;
        }

        return dp[n];
    }

}
