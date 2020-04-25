package boj.dp;

import java.io.*;

public class BOJ_2225_합분해_second {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }

    private static void output(int res) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res + "\n");
        bw.flush();
        bw.close();
    }

    private static int solve(){
        int[][] dp = new int[k+1][n+1];

        for(int i=1;i<=n;i++){
            dp[1][i] = 1;
        }

        for(int i=1;i<=k;i++){
            dp[i][1] = i;
        }

        for(int i=2;i<=k;i++){
            for(int j=2;j<=n;j++){
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
            }
        }

        return dp[k][n];
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        k = Integer.parseInt(str[1]);

        br.close();
    }


}
