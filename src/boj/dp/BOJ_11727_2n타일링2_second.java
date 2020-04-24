package boj.dp;

import java.io.*;

public class BOJ_11727_2n타일링2_second {
    static int n;
    static int answer;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        int[] dp = new int[n+1];

        for(int i=1;i<=n;i++){
            if(i==1) {
                dp[i] = 1;
                continue;
            }
            if(i==2) {
                dp[i] = 3;
                continue;
            }
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % 10007;
        }

        answer = dp[n];
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
    }


}
