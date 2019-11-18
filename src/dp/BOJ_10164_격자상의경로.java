package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * dp[i][j] = dp[i-1][j] + dp[i][j-1]
 * 오른쪽 또는 아래로 밖에 못가기 때문에
 */
public class BOJ_10164_격자상의경로 {
    private static int dp[][];
    private static int a[][];
    private static int n,m,o, cnt=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        o = Integer.parseInt(st.nextToken());

        a = new int[n+1][m+1];
        dp = new int[n+1][m+1];
        int num = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                a[i][j] = num;
                num++;
                dp[i][j] = -1;
            }
        }
        //o가 0일때는 모든 경로의 수 구하기
        if(o == 0){
            System.out.println(solve(n,m));
            return;
        }
        //o일 때 sovle메소드 실행
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i][j] == o)
                    System.out.println(solve(i,j));
            }
        }
    }

    private static int solve(int x, int y) {
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1)
                    continue;
                //오른쪽이나 밑으로 밖에 못가므로
                //목표지점 전에서 밑으로 내려가버린 경우와
                //목표지점 전에서 오른쪽으로 가버린 경우는 0으로 계산
                if((i>x && j<y) || (i<x && j>y))
                    dp[i][j] = 0;
                else
                    //바로 위와, 바로 왼쪽의 합
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n][m];
    }
}
