package programmers.dp;

public class PGMS_타일장식물 {
    static int dp[];

    public static void main(String[] args) {
        PGMS_타일장식물 pgms_타일장식물 = new PGMS_타일장식물();
        System.out.println(pgms_타일장식물.solution(6));
    }

    public long solution(int N) {
        long answer = 0;
        dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=N;i++){
            dp[i] = dp[i-2] + dp[i-1];
        }

        answer =  2 * (2*dp[N] + dp[N-1]);

        return answer;
    }
}
