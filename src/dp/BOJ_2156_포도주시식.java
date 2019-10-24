package dp;

import java.util.Scanner;
/*
 * oox 의 경우 dp[i-1] 가 된다.  -> 이 경우를 생각 못해서 헤맸다...
 * oxo 의 경우 dp[i-2] + drink[i] 가 된다.
 * xoo 의 경우 do[i-3] + drink[i-1] + drink[i] 가 된다.
 */
public class BOJ_2156_포도주시식 {
    static long[] dp;
    static int[] drink;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new long[n+1];
        drink = new int[n+1];
        for(int i=1;i<=n;i++){
            drink[i] = sc.nextInt();
        }

        System.out.println(solve(n));
    }

    private static long solve(int n) {

        if(n == 1)
            return drink[1];
        if(n == 2)
            return drink[1] + drink[2];

        dp[1] = drink[1];
        dp[2] = drink[2] + dp[1];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(drink[i] + drink[i-1] + dp[i-3], drink[i] + dp[i-2]);
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        return dp[n];
    }

}
