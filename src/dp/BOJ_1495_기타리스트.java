package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1495_기타리스트 {
    private static int vol[];
    private static boolean dp[][];
    private static int n,s,m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st1.nextToken());
        s = Integer.parseInt(st1.nextToken());
        m = Integer.parseInt(st1.nextToken());
        vol = new int[n+1];
        dp = new boolean[n+1][1001];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++) {
            vol[i] = Integer.parseInt(st2.nextToken());
        }
        System.out.println(solve(n));
    }

    private static int solve(int n) {
        dp[0][s] = true;

        for(int i=1;i<=n;i++){
            for(int j=0;j<=m;j++){
                //바로 전까지의 합을 보고 true면 밑으로 내려감
                if(!dp[i-1][j])
                    continue;
                //m을 넘지 않는 선에서 +
                if(j+vol[i] <= m)
                    dp[i][j+vol[i]] = true;
                //0이하로 가지 않는 선에서 -
                if(j-vol[i] >= 0)
                    dp[i][j-vol[i]] = true;
            }
        }

        int max = -1;
        for(int i=m;i>=0;i--){
            if(dp[n][i]) {
                max = i;
                break;
            }
        }

        return max;
    }
}
