package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * programmers.dp[n]:n의 제곱항의 개수
 */
public class BOJ_1699_제곱수의합 {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        int num=1;
        //1부터 n까지의 숫자를 최대값으로 초기화 하였다. 어떤 수의 제곱이 되는 수는 1로, 그렇지 않은 수는 그 수 자체로 초기화
        for(int i=1;i<=n;i++){
            if(i == Math.pow(num,2)){
                num++;
                dp[i] = 1;
            }else{
                dp[i] = i;
            }
        }

        for(int i=1;i<=n;i++){
            //원래는 if로 조건문을 넣었는데 시간초과가 떠서 반복문의 조건을 바꾸어 주어서 성공했다
            for(int j=1;i >= Math.pow(j,2);j++){
                //초기화된 수와 반복문을 돌리며 비교한 수 중에 작은 것을 programmers.dp[i]에 담아주었다.
                dp[i] = Math.min(dp[i], dp[(int)Math.pow(j,2)] + dp[i-(int)Math.pow(j,2)]);
            }
        }

        return dp[n];
    }
}
