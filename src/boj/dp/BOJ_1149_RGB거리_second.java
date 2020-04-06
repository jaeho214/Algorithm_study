package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1149_RGB거리_second {
    static int arr[][];
    static int n;
    static int dp[][];
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve());
    }

    private static int solve() {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];
        for(int i=0;i<n;i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + arr[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + arr[i][2];
        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][3];
        dp = new int[n][3];
        for(int i=0;i<n;i++){
            String[] strArr = br.readLine().split(" ");
            for(int j=0;j<3;j++){
                arr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
    }
}
