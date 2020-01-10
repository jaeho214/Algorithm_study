package dp;

public class PGMS_등굣길 {
    public static void main(String[] args) {
        int[][] puddles = {{2,2}};
        PGMS_등굣길 pgms_등굣길 = new PGMS_등굣길();
        System.out.println(pgms_등굣길.solution(4,3,puddles));
    }

    public int solution(int m, int n, int[][] puddles){
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<puddles.length;i++){
            dp[puddles[i][1]][puddles[i][0]]=-1;
        }
        dp[1][1] = 1;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++) {
                //집에선 continue
                if (i == 1 && j == 1)
                    continue;
                //웅덩이면 최단거리의 개수 0개
                if (dp[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }
                //바로 직전까지의 최단거리들의 합
                //이렇게 값을 dp에 저장할때마다 나머지를 구했어야했는데 return할때만 해줘서 오래걸림..
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
            }
        }

        return dp[n][m];
    }

}
