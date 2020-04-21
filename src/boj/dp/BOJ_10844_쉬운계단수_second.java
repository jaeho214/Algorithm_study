package boj.dp;

import java.io.*;

public class BOJ_10844_쉬운계단수_second {
    static int n;
    static long answer=0;
    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }

    private static void solve() {
        long dp[][] = new long[n+1][10];

        dp[1][0] = 0;
        for(int i=1;i<10;i++){
            dp[1][i] = 1;
        }

        for(int i=2;i<=n;i++){
            for(int j=0;j<10;j++){
                if(j==0){
                    dp[i][j] = dp[i-1][j+1];
                }else if(j==9){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
                }
            }
        }
        for(int i=0;i<10;i++){
            answer += dp[n][i];
        }
        answer %= 1000000000;
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
    }


}
