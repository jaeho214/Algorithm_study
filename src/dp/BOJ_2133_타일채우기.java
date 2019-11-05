package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * dp[n] = 3 x dp[n-2] + (2 x dp[n-4] + 2 x dp[n-6] .....)
 * 4개부터 짝수개 일때는 높이가 3이기 때문에 위아래 반전으로 두 배의 경우의 수가 존재한다.
 */
public class BOJ_2133_타일채우기 {
    static int dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        //System.out.println(bottomUp(n));
        System.out.println(topDown(n));
    }

    private static int topDown(int n){
        if(n==0){
            dp[0] = 1;
            return 1;
        }if(n==1) {
            dp[1] = 0;
            return 0;
        }if(n==2) {
            dp[2] = 3;
            return 3;
        }

        dp[n] = 3 * topDown(n-2);

        for(int i=3;i<=n;i++){
            if(i%2==0)
                dp[n] += topDown(n-i) * 2;
        }

        return dp[n];
    }

    private static int bottomUp(int n) {
        if(n==1)
            return 0;
        if(n==2)
            return 3;
        dp[0] = 1;
        dp[1] = 0;
        dp[2] = 3;

        for(int i=3;i<=n;i++){
            dp[i] = 3 * dp[i-2];
            for(int j=4;j<=i;j++) {
                if(j%2==0){
                    //2로 곱해줬어야 했는데 2의 배수를 곱해줘서 틀림
                    dp[i] += dp[i-j] * 2;
                }
            }
        }

        return dp[n];
    }


}
