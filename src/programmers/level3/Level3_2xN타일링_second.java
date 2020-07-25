package programmers.level3;

public class Level3_2xN타일링_second {
    public static void main(String[] args) {
        Level3_2xN타일링_second level3_2xN타일링_second = new Level3_2xN타일링_second();
        System.out.println(level3_2xN타일링_second.solution(4));
    }
    public int solution(int n) {

        return bottomUp(n);

    }

    public int bottomUp(int n){
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        for(int i=3;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
        }

        return dp[n];
    }
}
