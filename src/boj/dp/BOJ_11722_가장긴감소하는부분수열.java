package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://developer-mac.tistory.com/72
 * 수열 문제가 너무 어렵다 적응이 안된다..
 */
public class BOJ_11722_가장긴감소하는부분수열 {
    static int[] dp;
    static int[] a;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = new int[n+1];
        dp = new int[n+1];

        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solve(n));
    }

    private static int solve(int n) {
        for(int i=1;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<=i;j++){
                //기준 숫자보다 큰데 그 숫자까지의 부분수열이 자기 자신까지의 수열보다 길면
                if(a[i] < a[j] && dp[i] <= dp[j]){
                    //자기 자신까지의 수열길이 +1
                    dp[i] = dp[j]+1;
                }else if(a[i] == a[j]){
                    dp[i] = dp[j];
                }
            }
        }

        int max=0;
        for(int i=1;i<=n;i++){
            if(max < dp[i])
                max = dp[i];
        }
        return max;
    }
}
