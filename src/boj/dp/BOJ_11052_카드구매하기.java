package boj.dp;

import java.util.Scanner;

public class BOJ_11052_카드구매하기 {
    static int[] card;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        card = new int[n+1];
        dp = new int[n+1];

        for(int i=1;i<=n;i++){
            card[i] = sc.nextInt();
        }

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n==1)
            return card[1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                //j개가 들어있는 카드팩을 구매하고 i-j개의 카드를 구매하는 방식
                dp[i] = Math.max(dp[i], dp[i - j] + card[j]);
            }
        }

        return dp[n];
    }
}
