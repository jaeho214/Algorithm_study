package dp;

import java.util.Scanner;
/*
 * 삼성 문제로 나왔다고 해서 꼭 풀고 싶었는데 못풀었다
 * i를 1부터 하는 것이 아니라 뒤에서부터 왔다
 * i일 수익 + i일에 하는 상담 후 부터 얻을 수 있는 최대 수익과 i+1일부터 얻을 수 있는 최대 수익 비교
 */
public class BOJ_14501_퇴사 {
    static int[] dp;
    static int[] t;
    static int[] p;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        t = new int[n+2];
        p = new int[n+2];
        dp = new int[n+2];

        for(int i=1;i<=n;i++){
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        System.out.println(solve(n));
    }

    private static int solve(int n) {

        for(int i=n;i>0;i--){
            int day = i + t[i]; // i일에 일을하고 난 후의 날짜

            if(day <= n+1) // 퇴사 전이라면
                //i일 수익 + day부터 받을 수 있는 최대 금액, i+1일부터 받을 수 있는 최대 금액 중 높은 것 찾기
                dp[i] = Math.max(p[i]+dp[day], dp[i+1]);
            else
                dp[i] = dp[i+1];
        }
        return dp[1];
    }
}
