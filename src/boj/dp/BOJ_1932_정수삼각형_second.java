package boj.dp;

import java.io.*;

public class BOJ_1932_정수삼각형_second {
    static int n;
    static int[][] arr;
    static int[][] dp;
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        dp[0][0] = arr[0][0];

        for(int i=1;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(j==0)
                    dp[i][j] = dp[i-1][j] + arr[i][j];
                else if(j==arr[i].length-1)
                    dp[i][j] = dp[i-1][j-1] + arr[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + arr[i][j];
            }
        }

        for(int i=0;i<dp.length;i++){
            answer = Math.max(dp[n-1][i], answer);
        }
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < str.length; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }
        br.close();
    }
}
