package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * .... n-3 n-2 n-1 n 까지 있을 때
 * 마지막 계단을 무조건 밟아야 하므로 나올 수 있는 가능성은
 * 1. n-2, n
 * 2. n-3, n-1, n
 * 위 두 가지 가능성이다.
 * n-1을 stair 값으로 처리해준 이유는 dp[n-1]을 사용해버리는 순간
 * 계단을 세번 연속 밟을 수 있는 가능성이 생겨버려 값이 더 커지게 된다.
 * 따라서 점화식은 dp[n] = max(dp[n-3] + stair[n-1], dp[n-2]) + stair[n];
 */
public class BOJ_2579_계단오르기_second {
    static int[] stair;
    static int n;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static int solve() {
        int dp[] = new int[n+1];

        if(n==1)
            return stair[1];

        dp[0] = 0;
        dp[1] = stair[1];
        dp[2] = stair[1] + stair[2];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-3] + stair[i-1], dp[i-2]) + stair[i];
        }

        return dp[n];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        stair = new int[n+1];
        for(int i=1;i<=n;i++){
            stair[i] = Integer.parseInt(br.readLine());
        }
    }
}
