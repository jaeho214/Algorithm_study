package boj.dp;

import java.io.*;

public class BOJ_11052_카드구매하기_second {
    static int n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }

    private static int solve() {
        int dp[] = new int[n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                //i장짜리 카드를 하나 사는 금액과 i-j개까지 사고 j장짜리 카드를 사는 경우 중 최대값
                dp[i] = Math.max(dp[i], dp[i-j] + arr[j-1]);
            }
        }
        return dp[n];
    }

    private static void output(int result) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        String[] str = br.readLine().split(" ");

        for(int i=0;i<str.length;i++){
            arr[i] = Integer.parseInt(str[i]);
        }

        br.close();
    }
}
