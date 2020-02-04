package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://zorba91.tistory.com/159
 * programmers.dp[n][m] = (n,m) 지점일 때 존재하는 경로의 개수
 */
public class BOJ_1520_내리막길 {
    static  int n,m;
    static int[][] a;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());

        a = new int[n+1][m+1];
        dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                //방문하지 않은 곳은 -1로 초기화
                dp[i][j] = -1;
            }
        }

        System.out.println(solve(1,1));
    }

    private static int solve(int x, int y) {
        if(x == n && y == m){
            return 1;
        }

        if(dp[x][y] == -1){
            //방문을 하고 나서
            dp[x][y] = 0;

            //x,y 좌표를 확인하고 각 좌표에 저장된 값들을 비교한다
            //a[x][y] 보다 작은 값이 있는 곳으로 이동한다
            if(x > 1 && a[x][y] > a[x-1][y])
                //위로 이동
                dp[x][y] += solve(x-1,y);
            if(x < n && a[x][y] > a[x+1][y])
                //아래로 이동
                dp[x][y] += solve(x+1,y);
            if(y > 1 && a[x][y] > a[x][y-1])
                //좌로 이동
                dp[x][y] += solve(x,y-1);
            if(y < m && a[x][y] > a[x][y+1])
                //우로 이동
                dp[x][y] += solve(x, y+1);
        }

        return dp[x][y];

    }
}
