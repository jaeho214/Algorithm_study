package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * https://twinw.tistory.com/126
 * 이차원배열에서 b를 a에 비교해가며 값이 같을 때 카운트를 하기 때문에
 * 부분수열에 맞게 카운팅을 할 수 있다.
 * 혹여나 중복이 되더라도 마지막으로 나오는 중복수에서 또 카운트를 하기 때문에 문제 없음
 */
public class BOJ_9251_LCS {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        dp = new int[a.length()+2][b.length()+2];

        System.out.println(solve(a,b));
    }

    private static int solve(String a, String b) {
        for(int i=0;i<=a.length();i++){
            for(int j=0;j<=b.length();j++){
                dp[i][j] = 0;
            }
        }

        for(int i=1;i<=a.length();i++){
            for(int j=1;j<=b.length();j++){
                // 문자가 같으면
                if(a.charAt(i-1) == b.charAt(j-1))
                    //왼쪽 대각선 위의 값에 +1
                    dp[i][j] = dp[i-1][j-1]+1;
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[a.length()][b.length()];
    }
}

