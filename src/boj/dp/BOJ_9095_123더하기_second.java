package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9095_123더하기_second {
    public static void main(String[] args) throws IOException {
        int[] input = input();

        int max = Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++){
            max = Math.max(max, input[i]);
        }
        int[] arr = solve(max);
        for(int i=0;i< input.length;i++){
            System.out.println(arr[input[i]]);
        }
    }

    private static int[] solve(int num){
        int dp[] = new int[num+1];

        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i=4;i<=num;i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp;
    }

    private static int[] input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        return arr;
    }
}
