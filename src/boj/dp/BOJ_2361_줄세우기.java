package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2361_줄세우기 {
    private static int[] dp;
    private static int[] a;
    public static void main(String[] args) {
        int n = input();
        int result = solve(n);
        output(result);
    }

    private static int solve(int n) {
        //LIS 를 구하고
         for(int i=1;i<=n;i++){
             dp[i] = 1;
             for(int j=1;j<=i;j++){
                 if(a[i] > a[j] && dp[i] < dp[j]+1)
                     dp[i] = dp[j]+1;
             }
        }
         int max = dp[1];
         for(int i=1;i<=n;i++){
             max = Math.max(max, dp[i]);
         }
        //LIS를 제외한 나머지 숫자들을 옮겨야 함
        return n - max;
    }

    private static void output(int result) {
        System.out.println(result);
    }

    private static int input() {
        int n=0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = new int[n+1];
            dp = new int[n+1];
            for(int i=1;i<=n;i++){
                a[i] = Integer.parseInt(br.readLine());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
        return n;
    }
}
