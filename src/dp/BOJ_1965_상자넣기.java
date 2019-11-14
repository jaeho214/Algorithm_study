package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 그냥 LIS 알고리즘으로 풀어주면 된다.
 * dp[n] : n번째 숫자까지 가장 긴 증가 부분수열
 */
public class BOJ_1965_상자넣기 {
    static int dp[];
    static int a[];
    public static void main(String[] args) throws IOException {
        int n = input();
        int result = solve(n);
        output(result);
    }

    //solution
    private static int solve(int n) {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(a[i] > a[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
                else if(a[i] == a[j])
                    dp[i] = dp[j];
            }
        }

        int max = dp[1];
        for(int i=1;i<=n;i++){
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //output
    private static void output(int result) {
        System.out.println(result);
    }

    //input
    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = new int[n+1];
        dp = new int[n+1];
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        return n;
    }

}
