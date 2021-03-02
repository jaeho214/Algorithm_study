package hackerrank;

public class Sam_and_substrings {
    public static void main(String[] args) {
        System.out.println(substrings("16"));
    }
    private static final int MOD = 1000000007;
    static long substrings(String n) {
        long[] dp = new long[n.length()+1];

        dp[0] = 0;
        long answer = dp[1] = n.charAt(0)- '0';

        for(int i=2;i<=n.length();i++){
            dp[i] = ((dp[i-1]*10) + ((n.charAt(i-1)-'0')*i))% MOD;
            answer += dp[i];
        }

        return answer % MOD;
    }
}
