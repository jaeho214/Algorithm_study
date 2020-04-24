package boj.dp;

import java.io.*;

public class BOJ_9461_파도반수열_second {
    static int n;
    static int arr[];
    static long dp[];
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve(){
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            max = Math.max(arr[i], max);
        }

        dp = new long[max+1];

        for(int i=1;i<=max;i++){
            if(i<=3){
                dp[i] = 1;
                continue;
            }
            if(i<=5){
                dp[i] = 2;
                continue;
            }
            dp[i] = dp[i-5] + dp[i-1];
        }
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0;i<arr.length;i++){
            bw.write(dp[arr[i]] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        br.close();
    }

}
