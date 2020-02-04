package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9252_LCS2 {
    private static int[][] dp;
    private static String a,b;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine();
        b = br.readLine();
        dp = new int[b.length()+1][a.length()+1];
        output();
    }

    private static void output() {
        System.out.println(solve());
        System.out.println(recursion(b.length(), a.length()));
    }

    private static int solve() {
        for(int i=1;i<=b.length();i++){
            for(int j=1;j<=a.length();j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<=b.length();i++){
            for(int j=1;j<=a.length();j++){
                if(a.charAt(j-1) == b.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[b.length()][a.length()];
    }

    //뒤에서부터 확인하는 재귀
    private static String recursion(int x, int y){
        if(x==0 || y==0)
            return "";
        else if(b.charAt(x-1) == a.charAt(y-1)){
            return recursion(x-1, y-1) + b.charAt(x-1);
        }else{
            if(dp[x][y-1] > dp[x-1][y] )
                return recursion(x,y-1);
            else
                return recursion(x-1,y);
        }
    }
}
