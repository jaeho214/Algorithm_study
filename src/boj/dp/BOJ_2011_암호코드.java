package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * https://mygumi.tistory.com/137
 * 14라는 숫자는 {1, 4} => A, D  , {14} => N
 * programmers.dp[n] = programmers.dp[n](1) + programmers.dp[n-1](4) => 한자리 숫자
 * programmers.dp[n] = programmers.dp[n](14) + programmers.dp[n-2](0) => 두자리 숫자
 */
public class BOJ_2011_암호코드 {
    private static int ch[];
    private static int dp[];
    public static void main(String[] args) throws IOException {
        int n = input();
        int result = solve(n);
        output(result);
    }
    //output
    private static void output(int result) {
        System.out.println(result);
    }
    //solution
    private static int solve(int n) {
        dp[0] = 1;

        for(int i=1;i<=n;i++){
            if(ch[i] != 0){
                //한자리일 경우 한자리 한자리 따로 계산하고
                dp[i] = (dp[i] + dp[i-1]) % 1000000;
            }

            int x = ch[i] + ch[i-1]*10;
            //두자리로 붙였을 때 범위에 포함된 경우
            if(10 <= x && x <= 26){
                //두자리짜리로 계산산
               dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }
        }

        return dp[n] % 1000000;
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        ch = new int[str.length()+1];
        dp = new int[str.length()+1];
        for(int i=1;i<=str.length();i++)
            ch[i] = str.charAt(i-1) - '0';

        return str.length();
    }
}
