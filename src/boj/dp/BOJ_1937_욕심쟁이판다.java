package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://aig2029.tistory.com/77
 * 비슷하게까지 접근했지만 결국 풀지 못했다.
 * 값을 비교하여 큰값을 넣어주어야 하는데 계속 값을 더해줘서 크게 나왔다
 */
public class BOJ_1937_욕심쟁이판다 {
    private static int[][] a;
    private static int[][] dp;
    private static int n;

    private static final int[] row = {0, 0,-1,0,1};
    private static final int[] col = {0, -1,0,1,0};

    public static void main(String[] args) throws IOException {
        n = input();
        int result = 0;
        //배열의 모든 값들을 확인하기 위함
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                result = Math.max(result, solve(i,j));
            }
        }
        output(result);
    }

    private static int solve(int x, int y) {

        if(dp[x][y] > 0)
            return dp[x][y];

        dp[x][y] = 1;
        for(int i=1;i<=4;i++){
            //다음 행과 열을 row 배열과 col 배열을 통해 동서남북으로 지정함
            int nextRow = x + row[i];
            int nextCol = y + col[i];
            //다음 행선지가 1~n 배열 밖을 벗어나면 continue
            if(nextRow<1 || nextRow>n || nextCol<1 || nextCol>n )
                continue;
            //현재 위치의 값이 다음 행선지의 값보다 크거나 같으면 continue
            if(a[nextRow][nextCol] <= a[x][y])
                continue;
            //다음 행선지의 값이 현재 위치의 값보다 크면
            //다음 행선지까지의 dp값을 계산한 후 +1을 한 값과
            //현재까지의 dp값을 비교하여
            //큰 값을 dp값에 넣어줌
            dp[x][y] = Math.max(dp[x][y], solve(nextRow, nextCol) + 1);
        }

    return dp[x][y];
    }

    private static void output(int result) {
        System.out.println(result);
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n+1][n+1];
        dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        return n;
    }
}
