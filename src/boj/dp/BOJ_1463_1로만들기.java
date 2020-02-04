package boj.dp;

import java.util.Scanner;
/*
 * n의 연산 횟수는 n-1연산 횟수+1 or n/2의 연산 횟수 +1 or n/3의 연산 횟수 + 1 이다.
 * 예를 들어 10의 연산 횟수는 5의 연산횟수 +1 또는 9의 연산 횟수 +1이다.
 * +1은 10에서 5나9로 갈때의 연산 횟수다.
 *
 */
public class BOJ_1463_1로만들기 {

    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        dp = new int[N+1];

        System.out.println(topDown(N));

    }
    // n에서부터 1까지 값을 빼거나 나눠가면서 푸는 방식
    private static int topDown(int n) {
        if (n == 1)
            return 0;
        if (dp[n] > 0)
            return dp[n];
        dp[n] = topDown(n - 1) + 1; //dp에 -1 연산의 횟수를 넣고
        if (n % 2 == 0) {
            dp[n] = Math.min(dp[n], topDown(n / 2) + 1); // /2와 횟수를 비교 후 작은 것을 넣고
        }
        if (n % 3 == 0) {
            dp[n] = Math.min(dp[n], topDown(n / 3) + 1); // /3과 횟수를 비교 후 작은 것을 넣고
        }
        return dp[n]; //반환
    }

    // 1에서부터 n 까지 반복문을 통해 푸는 방식
    private static int bottomUp(int n) {
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 1;
            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) { //-1과 /2의 연산횟수 비교
                dp[i] = dp[i / 2] + 1;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) { //-1과 /3의 연산횟수 비교
                dp[i] = dp[i / 3] + 1;
            }
        }
        return dp[n];
    }
}
