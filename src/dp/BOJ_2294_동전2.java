package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2294_동전2 {
    static int[] a;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        a = new int[n+1];
        dp = new int[k+1];
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solve(n,k));
    }

    private static int solve(int n, int k) {
        if(n==1)
            return k;

        dp[0] = 0;

        //최소값을 찾기위해 전체를 최대값으로 초기화화
       for(int i=1;i<=k;i++)
            dp[i] = 10001;

        for(int i=1;i<=n;i++){
            for(int j=a[i]; j<=k;j++){
                //dp[j]: j까지 최소 개수, dp[j-a[i]]+1: a[i] 하나로 만들 수 있는 경우
                dp[j] = Math.min(dp[j], dp[j-a[i]] + 1);
            }
        }

        //최소를 구하지 못했으면 -1
        if(dp[k] == 10001)
            dp[k] = -1;


        return dp[k];
    }
}
