package dp;

import java.util.Scanner;
/*
 * 이 문제는 진짜 너무 헷갈려서 점화식 찾기도 힘들었다
 * 점화식은 dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1] 이다
 * j가 0이거나 9인 경우에는 각각 1과 8밖에 나올 수 없다.
 * 점화식의 의미는 길이가 i 일때 마지막자리 숫자가 j일때
 * i-1 길이에서 j가 j+1, j-1로 나아갈 수 있다는 뜻이다.
 * 예를 들어 234라는 숫자가 있으면
 * 23에서 232와 234로 나아갈 수 있다는 뜻이다 */
public class BOJ_10844_쉬운계단수 {
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new long[n+1][11];
        System.out.println(solve(n));
    }

    private static long solve(int n) {
        for(int i=1;i<=9;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            dp[i][0] = dp[i-1][1]; // 길이가 i일때 숫자가 0이면 이전 단계에서는 1이 될수밖에 없다. 1->0
            for(int j=1;j<=9;j++){
                dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
            }
        }

        long sum = 0;
        for(int i=0; i< 10;i++){
            sum += dp[n][i];
        }

        return sum % 1000000000;
    }
}
