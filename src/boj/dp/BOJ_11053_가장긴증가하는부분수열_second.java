package boj.dp;

import java.io.*;

public class BOJ_11053_가장긴증가하는부분수열_second {
    static int n;
    static int arr[];
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            answer = Math.max(answer, dp[i]);
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
        arr = new int[n];
        String[] str = br.readLine().split(" ");
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(str[i]);
        }
    }
}
