package boj.dp;

import java.io.*;

public class BOJ_9465_스티커_second {

    static int res[];
    public static void main(String[] args) throws IOException {
        input();
        output();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        res = new int[t];
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int arr[][] = new int[2][n];
            for(int j=0;j<2;j++){
                String[] str = br.readLine().split(" ");
                for(int k=0;k<str.length;k++){
                    arr[j][k] = Integer.parseInt(str[k]);
                }
            }
            res[i] = solve(n, arr);
        }
    }


    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int r : res)
            bw.write(r + "\n");
        bw.flush();
        bw.close();
    }


    private static int solve(int n, int[][] arr) {
        int dp[][] = new int[2][n];

        dp[0][0] = arr[0][0];
        dp[1][0] = arr[1][0];
        dp[0][1] = arr[1][0] + arr[0][1];
        dp[1][1] = arr[0][0] + arr[1][1];
        for(int i=2;i<n;i++){
            int max = Math.max(dp[1][i-2], dp[0][i-2]);
            dp[0][i] = Math.max(max,dp[1][i-1]) + arr[0][i];
            dp[1][i] = Math.max(max,dp[0][i-1]) + arr[1][i];
        }

        return Math.max(dp[1][n-1], dp[0][n-1]);
    }
}
