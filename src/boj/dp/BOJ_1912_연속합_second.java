package boj.dp;

import java.io.*;

public class BOJ_1912_연속합_second {
    static int n;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        int[] dp = new int[n];
        answer = arr[0];
        dp[0] = arr[0];
        for(int i=1;i<n;i++){
            dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            answer = Math.max(dp[i], answer);
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
        br.close();
    }
}
