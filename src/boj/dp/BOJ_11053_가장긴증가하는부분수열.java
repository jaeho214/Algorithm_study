package boj.dp;

import java.util.Scanner;
/*
 * 이 문제도 굉장히 헷갈렸다.
 * j를 기준으로 j 이전까지의 숫자들을 비교해가며 카운트를 했다
 * 이전보다 높은 숫자가 나왔을때 카운트를 1씩 해가며 결과값을 늘렸고
 * max를 통해 비교했다.
 */
public class BOJ_11053_가장긴증가하는부분수열 {
    static int[] dp;
    static int[] num;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n+1];
        num = new int[n+1];
        for(int i=1;i<=n;i++){
            num[i] = sc.nextInt();
        }

        System.out.println(sovle(n));
    }

    private static int sovle(int n) {
        if(n==1)
            return 1;

        dp[1] = 1;
        int max=0;

        for(int i=2;i<=n;i++){
            dp[i] = 1;
            for(int j=1;j<i;j++){
                if(num[i] > num[j] && dp[j]+1 > dp[i]) //이전 숫자보다 큰지확인하고 카운트
                    dp[i] = dp[j]+1;
            }

            if(max < dp[i])
                max = dp[i];
        }

        return max;
    }
}
