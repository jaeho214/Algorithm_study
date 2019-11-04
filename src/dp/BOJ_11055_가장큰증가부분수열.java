package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp[n] = n 까지의 가장 큰 부분 증가수열의 값
 */
public class BOJ_11055_가장큰증가부분수열 {
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
        if(n==1)
            return a[1];

        int max = 0;
        for(int i=1;i<=n;i++){
            dp[i] = a[i];
            for(int j=1;j<i;j++){
                //a[i]를 기준으로 a[j]들과 비교해 나가며 증가 부분 수열일때
                //dp[i](자기 자신까지의 합)과 dp[j](j 까지의 합)+자기 자신 값 을 비교한다.
                if(a[j] < a[i] && dp[i] < dp[j] + a[i])
                    dp[i] = dp[j] + a[i];
                if(max < dp[i])
                    max = dp[i];
            }
        }

        return max;
    }
}
