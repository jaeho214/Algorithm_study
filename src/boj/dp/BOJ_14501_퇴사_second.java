package boj.dp;

import java.io.*;

public class BOJ_14501_퇴사_second {
    static int arr[][];
    static int n;
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }

    private static int solve() {
        int dp[] = new int[n+1];

        for(int i=n-1;i>=0;i--){
            int day = i + arr[i][0];

            if(day <= n)
                dp[i] = Math.max(arr[i][1] + dp[day], dp[i+1]);
            else
                dp[i] = dp[i+1];
        }

        return dp[0];
    }

    private static void output(int result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1][2];
        for(int i=0;i<n;i++){
            String[] str = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(str[0]);
            arr[i][1] = Integer.parseInt(str[1]);
        }

        br.close();
    }


}
