package boj.dp;

import java.util.Scanner;
/*
 * 점화식을 구했다기보단 규칙을 찾았다. 피보나치 점화식으로 풀 수 있었다.
 * 처음에 n이 1일때, 2일때 return 처리를 안해줘서 런타임에러가 났었는데 수정했다.
 * int로 해줬을 땐 숫자 범위가 초과하여 long으로 처리해줬다
 */
public class BOJ_2193_이친수 {
    static long[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1];

        System.out.println(solve(n));
    }

    private static long solve(int n){
        if(n==1)
            return 1;
        if(n==2)
            return 1;

        dp[1] = 1;
        dp[2] = 1;

        for(int i=3;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
