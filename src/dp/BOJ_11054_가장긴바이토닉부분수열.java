package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp[n] = n까지 가장 긴 증가하는 부분 수열의 길이
 * dpReverse[n] = n부터 마지막까지 가장 긴 감소하는 부분 수열의 길이
 */
public class BOJ_11054_가장긴바이토닉부분수열 {
    static int dp[], dpReverse[];
    static int a[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        a = new int[n+1];
        dp = new int[n+1];
        dpReverse = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            a[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
            dpReverse[i] = 1;

        }
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        if(n == 1)
            return 1;
        //앞에서부터 가장 긴 증가하는 부분수열을 구하고
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++) {
                if (a[i] > a[j] && dp[i] <= dp[j])
                    dp[i] = dp[j] + 1;
                else if (a[i] == a[j])
                    dp[i] = dp[j];
            }
        }

        //뒤에서부터 가장 긴 증가하는 부분수열을 구한다.
        for(int i=n;i>=1;i--){
            for(int j=n;j>=i;j--){
                if(a[i] > a[j] && dpReverse[i] <= dpReverse[j])
                    dpReverse[i] = dpReverse[j] + 1;
                else if(a[i] == a[j])
                    dpReverse[i] = dpReverse[j];
            }
        }

        //앞에서부터의 부분수열과 뒤에서부터의 부분수열의 합을 구하고 -1을 해주면 된다.
        //백준의 test case에서는 1번부터 8번까지의 증가하는 수열의 길이가 5이고, 8번부터 10번까지 감소하는 수열의 길이가 3이다
        //8번의 값을 중복해서 저장하므로 -1을 해주어 7이 된다.
        int max = dp[1]+dpReverse[1];
        for(int i=1;i<=n;i++)
            max = Math.max(dp[i] + dpReverse[i], max);

        return max-1;
    }
}
