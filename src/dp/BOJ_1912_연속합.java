package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 연속적으로 몇개가 나와야 하는지 너무 헷갈려서 힘들었다..
 * n번째 수와 n-1번째까지의 합+n번째 수 를 비교했다.
 * n번째 수가 더 크다면 n번째까지의 합이 무의미해진다.
 * max 변수를 사용하기 전에는 값이 이상하게 떴는데 max 변수를 이용해서 확실하게 최대값을 이끌어냄
 */
public class BOJ_1912_연속합 {
    static int[] dp;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        dp = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n==1)
            return a[1];
        if(n==2)
            return Math.max(Math.max(a[1], a[2]),a[1]+a[2]);

        dp[1] = a[1];
        int max = a[1];
        for(int i=2;i<=n;i++){
            dp[i] = Math.max(a[i], dp[i-1]+a[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
