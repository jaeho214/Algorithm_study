package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003_피보나치함수_second {
    public static void main(String[] args) {
        int[] arr = input();
        for(int i=0;i<arr.length;i++){
            int res[][] = solve(arr[i]);
            System.out.println(res[arr[i]][0] + " " + res[arr[i]][1]);
        }
    }

    private static int[][] solve(int num){
        int[][] dp = new int[num+2][2];

        dp[0][0] = 1;
        dp[1][1] = 1;

        for(int i=2;i<=num;i++){
            dp[i][0] = dp[i-1][0] + dp[i-2][0];
            dp[i][1] = dp[i-1][1] + dp[i-2][1];
        }

        return dp;
    }

    private static int[] input(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arr[] = {};
        try {
            int n = Integer.parseInt(br.readLine());
            arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return arr;
    }
}
