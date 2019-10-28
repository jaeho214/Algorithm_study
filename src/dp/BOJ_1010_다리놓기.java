package dp;

import java.math.BigInteger;
import java.util.Scanner;
/*
 * 겹치지 않는다? 단순히 29개의 다리 중에 13개의 다리를 뽑는 경우의 수만 구하면 됨
 * 굳이 겹치는 경우를 고려하지 않아도 됨
 * 반도체 설계 문제를 LIS 알고리즘으로 푼거처럼 꼬이는 경우, 겹치는 경우 이런거는 고려하지 않는 거 같다..
 */
public class BOJ_1010_다리놓기 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            dp = new int[n+1][m+1];

            System.out.println(solve(n, m));
        }
    }

    private static BigInteger solve(int n, int m) {
        BigInteger sum = new BigInteger("1");
        int temp = n;
        //5C3 = 5*4*3/3*2*1 =>5를 -1씩 3번 빼서 곱하고, 3을 -1씩 1이 될때까지 빼서 나눈다.
        while(n > 0) {
            sum = sum.multiply(BigInteger.valueOf(m));
            --n;
            --m;
        }

        while(temp > 0){
            sum = sum.divide(BigInteger.valueOf(temp));
            --temp;
        }

        return sum;
    }
}
