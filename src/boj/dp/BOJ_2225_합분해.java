package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://mygumi.tistory.com/135
 * programmers.dp[k][n] : 0~n까지의 수를 k번 더해서 n을 만들 수 있는 경우의 수
 * programmers.dp[k][n] += programmers.dp[k-1][n-L] => 마지막으로 더하는 수를 L 이라고 가정하였을 때 L 이전의 수들의 합은 n-L 이고 k 개에서 L을 제외하였으니 k-1개가 된다.
 */
public class BOJ_2225_합분해 {
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        dp = new int[k+1][n+1];
        System.out.println(solve(n,k));
    }

    private static int solve(int n, int k) {
        for(int i=0;i<=n;i++)
            dp[1][i] = 1;

        for(int i=1;i<=k;i++){
            for(int j=0;j<=n;j++){
                for(int l=0;l<=j;l++){
                    dp[i][j] += dp[i-1][j-l];
                    dp[i][j] %= 1000000000;
                }
            }
        }

        return dp[k][n];
    }
}
