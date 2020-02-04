package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://blog.naver.com/PostView.nhn?blogId=phj8498&logNo=221340992241
 * array[1][6] = min(array[1][k] + array[k+1][6] + d[0]*d[k]*d[6]
 */
public class BOJ_11049_행렬곱셈순서 {
    private static int dp[];
    private static int array[][];

    public static void main(String[] args) {
        int n = input();
        int result = solve(n);
        System.out.println(result);
    }

    private static int solve(int n) {
        for (int len = 2; len <= n; len++)
        {
            for (int i = 1; i <= n - len + 1; i++)
            {
                int j = i + len - 1;
                array[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                {
                    int cost = array[i][k] + array[k + 1][j] + dp[i - 1] * dp[k] * dp[j];
                    array[i][j] = Math.min(array[i][j], cost);
                }
            }
        }
        return array[1][n];
    }

    private static int input() {
        int n = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            array = new int[n+1][n+1];
            dp = new int[n+1];
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                dp[i] = Integer.parseInt(st.nextToken());
                dp[i+1] = Integer.parseInt(st.nextToken());
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }

        return n;
    }
}
