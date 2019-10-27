package dp;

import java.util.Scanner;
/*
 * 규칙을 확인하던중 i-1과 i-5의 합이 계속해서 나오는 것을 확인
 * 점화식 : d[n] = d[n-1] + d[n-5]
 */
public class BOJ_9461_파도반수열 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i=1;i<=n;i++){
            int num = sc.nextInt();
            dp = new long[num+1];
            System.out.println(solve(num));
        }
    }

    private static long solve(int n) {
        if(n<=3)
            return 1;
        if(n<=5)
            return 2;

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;

        for(int i=6;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-5]; //i-1의 길이와 i-5의 길이의 합
        }

        return dp[n];
    }
}
