package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://heedipro.tistory.com/265
 * dp[i][j] = i번째부터 j번째까지의 최소가치
 */
public class BOJ_11066_파일합치기 {
    private static int dp[][];
    private static int a[];
    private static int sum[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = new int[n+1];
            dp = new int[n+1][n+1];
            sum = new int[n+1];
            for(int j=1;j<=n;j++){
                a[j] = Integer.parseInt(st.nextToken());
                sum[j] = sum[j-1] + a[j];
                for(int k=1;k<=n;k++){
                    dp[j][k] = -1;
                }
            }
            System.out.println(solve(1,n));
        }
    }

    private static int solve(int start, int end){

        //종료 조건
        if(start >= end)
            return 0;

        // dp에 값이 있으면 그대로 리턴
        if(dp[start][end] != -1)
            return dp[start][end];

        // 현재값과 바로 다음값의 합 ex) dp[1][2],dp[2][3]
        if(end-start == 1)
            return a[start] + a[end];

        //최대값으로 미리 초기화 시켜놓고
        dp[start][end] = Integer.MAX_VALUE;

        for(int i=start;i<=end;i++){
            //dp[start][i] + dp[i+1][end]까지의 합을 구하고 start ~ end 까지의 합(sum[end] - sum[start-1])을 구해서 더하기
            //ex) 40 30 30 50 이면 70+80이 되는데 70+80=150이므로 70+80+150이 되어야 한다.
            int temp = solve(start, i) + solve(i+1, end) + sum[end] - sum[start-1];
            dp[start][end] = Math.min(dp[start][end], temp);
        }

        return dp[start][end];
    }
}
