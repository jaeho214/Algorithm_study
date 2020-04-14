package boj.dp;

import java.io.*;

public class BOJ_2156_포도주시식_second {
    static int n;
    static int[] drink;
    static int[] dp;
    static int answer;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    private static void solve() {

        if(n==1){
            answer = drink[2];
            return ;
        }
        if(n==2){
            answer = drink[1] + drink[2];
            return ;
        }

        dp[1] = drink[1];
        dp[2] = drink[1] + drink[2];

        for(int i=3;i<=n;i++){
            dp[i] = Math.max(dp[i-3] + drink[i-1], dp[i-2]) + drink[i];
            dp[i] = Math.max(dp[i], dp[i-1]);
        }

        answer = dp[n];
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        drink = new int[n+1];
        dp = new int[n+1];
        for(int i=1;i<=n;i++){
            drink[i] = Integer.parseInt(br.readLine());
        }

        br.close();
    }


}
