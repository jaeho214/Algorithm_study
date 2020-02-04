package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * programmers.dp[i][j] = i행 j열까지의 가장 큰 정사각형의 가로길이
 */
public class BOJ_1915_가장큰정사각형 {
    static int dp[][];
    static int a[][];
    static int n,m,sum;

    public static void main(String[] args) throws IOException {
        input();
        int result = solve();
        output(result);
    }

    private static void output(int result) {
        System.out.println(result);
    }

    private static int solve() {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //왼쪽, 위, 대각선 위의 값이 1이면
                if(a[i-1][j] == 1 && a[i-1][j-1] == 1 && a[i][j-1] == 1 ){
                    //그 중의 제일 작은 값 + 1
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-1]);
                    dp[i][j] = Math.min(dp[i][j], dp[i][j-1]) + 1;
                }
                //제일 큰 값을 찾기
                sum = Math.max(dp[i][j], sum);
            }
        }

        return sum*sum;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                a[i][j] = str.charAt(j-1)-48;
                if(a[i][j] == 1) {
                    dp[i][j] = 1;
                    //다 0일 수도 있으니까 1이 존재할 때만 sum에 1 초기화
                    sum = 1;
                }
            }
        }

    }
}
