package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class BOJ_11051_이항계수2 {
    // 팩토리얼을 구하는데 숫자가 너무 커져서 BigInteger를 사용함
    private static BigInteger dp[];
    private static int n,k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new BigInteger[n+1];
        if(n<k || k<0)
            System.out.println("0");
        else
            System.out.println(solve(n,k));
    }
    //팩토리얼 재귀함수를 통해 dp에 팩토리얼 값을 넣은 후
    private static BigInteger factorial(int n) {
        if(n==1) {
            // dp[1]이 ZERO로 초기화되어 있어서 런타임 에러가 났다
            dp[1] = BigInteger.ONE;
            return new BigInteger("1");
        }if(dp[n].compareTo(new BigInteger("0")) > 0)
            return dp[n];

        dp[n] = factorial(n-1).multiply(BigInteger.valueOf(n));

        return dp[n];

    }
    // dp에 저장된 팩토리얼 값들을 통해 이항계수 계산
    private static BigInteger solve(int n, int k){
        for(int i=1;i<=n;i++){
            dp[i] = BigInteger.ZERO;
        }
        // n과 k가 같은 경우도 존재 하는데 그 경우에는 n-k가 0이 되므로 0 인덱스 값을 초기화
        dp[0] = BigInteger.ONE;
        factorial(n);
        BigInteger result = dp[n].divide(dp[k].multiply(dp[n-k]));

        return result.mod(new BigInteger("10007"));

    }
}
