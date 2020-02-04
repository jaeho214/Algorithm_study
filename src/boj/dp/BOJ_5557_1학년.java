package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * programmers.dp[i][j] : i번째 수까지 j를 만들 수 있는 경우의 수
 */
public class BOJ_5557_1학년 {
    private static long dp[][];
    private static int a[];
    public static void main(String[] args) {
        int n = input();
        long result = solve(n);
        output(result);
    }

    private static long solve(int n) {
        //1번째까지 수로 1번째 수를 만들기 위한 방법은 1개
        dp[1][a[1]] = 1;
        for(int i=2;i<=n-1;i++){
            for(int j=0;j<=20;j++){
                //i-1 즉 이전의 숫자까지 j의 숫자를 만들 수 있어야 그 다음을 진행할 수 있음
                if(dp[i-1][j] > 0){
                    //목표 수- i번째수가 0보다 크거나 같을때 즉 음수값으로 가지 않을 때
                    if(j-a[i] >= 0)
                        //a[i]수 뺄 경우
                        dp[i][j-a[i]] += dp[i-1][j];
                    if(j+a[i] <= 20)
                        //a[i]수 더할 경우
                        dp[i][j+a[i]] += dp[i-1][j];
                }
            }
        }
        //n-1까지 a[n] 즉 마지막값을 만드는 경우의 수 리턴
        return dp[n-1][a[n]];
    }

    private static void output(long result) {
        System.out.println(result);
    }

    private static int input() {
        int n=0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = new int[n+1];
            dp = new long[n+1][21];
            for(int i=1;i<=n;i++)
                a[i] = Integer.parseInt(st.nextToken());

        }catch (IOException e){
            e.printStackTrace();
        }

        return n;
    }
}
