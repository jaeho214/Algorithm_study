package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 처음에 도출했던 점화식은
 * d[n] += d[n-1] + d[n-2] + d[n-5]이었다가
 * 코인은 입력 받기 때문에 다 다르지 않은가
 * 그래서 반복문을 돌려서 d[n] += d[n-coin[i]]으로 해야겠다고 생각했다
 */
public class BOJ_2293_동전1 {
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int cnt = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());
        coin = new int[cnt+1];
        dp = new int[num+1];
        for(int i=1;i<=cnt;i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(solve(cnt, num));
    }

    private static int solve(int c, int n) {
        // c = 코인의 개수, n = 목표 숫자

        dp[0] = 1;

        for(int i=1;i<=c;i++){ // 코인을 추가해가면서
            for(int j=coin[i];j<=n;j++){ // 1~n 원까지 다다르기 위한 경우의 수를
                if(j-coin[i] >= 0)//배열이 -1로 가지 않도록 하기 위해 조건
                    dp[j] += dp[j-coin[i]]; //축적
            }
        }

        return dp[n];
    }
}
