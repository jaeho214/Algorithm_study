package dp;

import java.util.Scanner;
/*
 * 재귀함수를 사용해보려다가 시간을 엄청 잡아먹었다
 * bottomUp 방식으로 쉽게 해결했다.
 * 0과 1이 나오는 횟수도 피보나치처럼 n-1 + n-2로 해결할 수 있었다.
 */
public class BOJ_1003_피보나치함수 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++) {
            int num = sc.nextInt();
            dp = new int[num+2][2];
            solve(num);
        }
    }

    private static void solve(int num) {
        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i=2;i<=num;i++) {
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        System.out.println(dp[num][0] + " " + dp[num][1]);
    }
}
