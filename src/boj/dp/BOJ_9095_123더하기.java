package boj.dp;

import java.util.Scanner;
/*
 * 입력받은 n이라는 숫자를 만들기 위해선 1,2,3 세가지 수만을 사용할 수 있기 때문에
 * 각각 n-1, n-2, n-3 까지의 만드는 방법의 수를 구하고 그 합을 구함
 */

public class BOJ_9095_123더하기 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int i=0;i<T;i++) {
            int num = sc.nextInt();
            dp = new int[num+1];
            System.out.println(solve(num));
        }
    }

    private static int solve(int n) {
        if(n==1)
            return 1;
        if(n==2)
            return 2;
        if(n==3)
            return 4;
        if(dp[n] > 0)
            return dp[n];

        dp[n] = solve(n-1) + solve(n-2) + solve(n-3);

        return dp[n];
    }
}

