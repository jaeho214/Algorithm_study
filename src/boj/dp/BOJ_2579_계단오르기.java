package boj.dp;

import java.util.Scanner;
/*
 * 마지막 계단은 무조건 밟아야 하고 계단을 세개 연속 오를 수 없기 때문에 나오는 가능성 두가지
 * 1. 마지막 바로 전 계단을 밟을 경우 -> 마지막 계단 점수 + 마지막 계단 바로전 점수 + 마지막-3 계단까지의 점수(세 개를 연속으로 밟을 수 없기 때문)
 * 2. 마지막 바로 전 계단을 밟지 않을 경우 -> 마지막 계단 점수 + 마지막-2 계단까지의 점수
 * 위 두가지를 비교 후 큰 값을 저장
 */
public class BOJ_2579_계단오르기 {
    static int[] dp;
    static int[] score;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        score = new int[n+1];
        dp = new int[n+1];
        for(int i=1;i<=n;i++) {
            score[i] = sc.nextInt();
        }

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        dp[1] = score[1];
        dp[2] = dp[1] + score[2];

        if(n<=2)
            return dp[n];

        for(int i=3;i<=n;i++) {
            dp[i] = Math.max(dp[i-3] + score[i-1] + score[i], dp[i-2] + score[i]);
        }

        return dp[n];

    }
}

