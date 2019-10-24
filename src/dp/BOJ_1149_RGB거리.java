package dp;

import java.util.Scanner;
/*
 * 세가지 가능성이 있다는 것 까진 파악을 했다
 * n이 파란색일 경우 n-1은 빨간색이나 초록생이어야 하고 ~~
 * 이것도 재귀로 풀려다가 오래 걸렸다. bottomUp 방식으로 풀었는데 선배 코드를 참고해서 풀었다.
 * 첫번째 값들을 미리 dp 배열에 넣어놓고
 * 두번째 집부터 세가지 가능성을 다 계산하였다.
 * 계산 후 모든 가능성 중에서 최소값 출력
 */

public class BOJ_1149_RGB거리 {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] house = new int[n+1][3];
        dp = new int[n+1][3];
        for(int i=1;i<=n;i++) {
            for(int j=0;j<3;j++) {
                house[i][j] = sc.nextInt();
            }
        }

        System.out.println(solve(house, n));
    }

    private static int solve(int[][] a, int n) {
        if(n == 1) {
            return min(a[0][0], a[0][1], a[0][2]);
        }

        dp[1][0] = a[1][0];
        dp[1][1] = a[1][1];
        dp[1][2] = a[1][2];

        for(int i=2;i<=n;i++) {
            dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2]) + a[i][0];
            dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2]) + a[i][1];
            dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1]) + a[i][2];
        }

        return min(dp[n][0], dp[n][1], dp[n][2]);

    }

    private static int min(int a1, int a2, int a3) {
        int min = Math.min(a1, a2);
        return Math.min(min, a3);
    }
}
