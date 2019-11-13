package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * solve1
 *  : 값을 손으로 적어보던중 규칙을 발견 dp[n] = dp[n-1]*2 + dp[n-2]
 * solve2
 *  : 3가지 경우의 수를 두었다. 1. n번째 사자가 없는 경우 2. n번째 사자가 왼쪽에 있는 경우 3. n번째 사자가 오른쪽에 있는 경우
 * 1번의 경우 n-1번째 사자가 없을 수도, 왼쪽에 있을 수도, 오른쪽에 있을 수도 있다 dp[n][0] = dp[n-1][0] + dp[n-1][1] + dp[n-1][2]
 * 2번의 경우 n-1번째 사자가 없을 수도 오른쪽에 있을 수도 있다 dp[n][1] = dp[n-1][0] + dp[n-1][2]
 * 3번의 경우 n-1번째 사자가 없을 수도 왼쪽에 있을 수도 있다 dp[n][2] = dp[n-1][0] + dp[n-1][1]
 * 최종 경우의 수는 이 세가지 경우의 수들의 합
 */
public class BOJ_1309_동물원 {
    //static int dp[];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        int n = input();
        int result = solve2(n);
        output(result);
    }

    private static int solve2(int n) {
        if(n==1)
            return 3;
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;
        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2]% 9901;
            dp[i][1] = dp[i-1][0] + dp[i-1][2]% 9901;
            dp[i][2] = dp[i-1][0] + dp[i-1][1]% 9901;

        }

        return dp[n][0] + dp[n][1] + dp[n][2] % 9901;
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][3];
        return n;
    }

    private static void output(int result) {
        System.out.println(result);
    }

//    private static int solve1(int n) {
//        if(n==1)
//            return 3;
//        if(n==2)
//            return 7;
//
//        dp[1] = 3;
//        dp[2] = 7;
//
//        for(int i=3;i<=n;i++){
//            dp[i] = dp[i-1]*2 + dp[i-2];
//            dp[i] %= 9901;
//        }
//
//        return dp[n];
//    }


}
