package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp에 누적값을 저장하면서 bottomUp 방식으로 진행
 * 나는 계단을 내려가는 것만 생각하고 밑에 있는 수들 중에 큰거를 찾으려고 애썼는데
 * 한 층 위에 있는 수들 중에서 큰거를 찾는 방법으로 하면 되었다..
 * j가 1일 때는 왼쪽 대각선 위의 값이 없으므로 오른쪽 대각선 위의 값을,
 * j가 마지막일 때는 오른쪽 대각선 위의 값이 없으므로 왼쪽 대각선 위의 값을 넣어주었다.
 * 그 외의 조건에서는 양쪽 대각선 위의 값들중 큰 값을 넣었다.
 */
public class BOJ_1932_정수삼각형 {
    static int[][] number;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n+1][n+1];
        number = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=i;j++){
                number[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve(n));
    }

    private static int solve(int n){
        if(n==1)
            return number[n][n];

        dp[1][1] = number[1][1];

        for(int i=2;i<=n;i++){
            for(int j=1;j<=i;j++){
                if (j==1)
                    dp[i][j] = dp[i-1][j] + number[i][j]; //오른쪽 대각선 위의 값
                else if(j==i)
                    dp[i][j] = dp[i-1][j-1] + number[i][j]; // 왼쪽 대각선 위의 값
                else
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + number[i][j]; //양쪽 대각선 위의 값중 큰 값
            }
        }
        return max(dp[n]); //마지막 행에서 가장 큰 값 반환
    }
    private static int max(int[] a){
        int max = 0;
        for(int i=1;i<a.length;i++){
            if(max < a[i])
                max = a[i];
        }
        return max;
    }
}
