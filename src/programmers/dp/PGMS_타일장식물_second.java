package programmers.dp;

public class PGMS_타일장식물_second {

    public static void main(String[] args) {
        PGMS_타일장식물_second pgms_타일장식물_second = new PGMS_타일장식물_second();
        System.out.println(pgms_타일장식물_second.solution(1));
    }


    public long solution(int N) {

        long[] dp = new long[N+2];
        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<dp.length;i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return 2*(dp[N] + dp[N+1]);
    }
}
