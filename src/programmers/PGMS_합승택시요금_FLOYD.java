package programmers;

import java.util.*;

public class PGMS_합승택시요금_FLOYD {
    public static void main(String[] args) {
        PGMS_합승택시요금_FLOYD pgms_합승택시요금FLOYD = new PGMS_합승택시요금_FLOYD();
        int[][] fares = {{4,1,10}, {3,5,24}, {5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};
        System.out.println(pgms_합승택시요금FLOYD.solution(6,4,6,2,fares));
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {

        int[][] dp = new int[n+1][n+1];

        for(int i=0;i<=n;i++){
            Arrays.fill(dp[i], 1000001);
            dp[i][i] = 0;
        }

        for(int[] fare : fares){
            dp[fare[0]][fare[1]] = fare[2];
            dp[fare[1]][fare[0]] = fare[2];
        }

        //k는 중간지점
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    //k를 중간지점으로 하고 거치는 방법과 거치지 않는 방법 비교 후 최소값 갱신
                    dp[i][j] = Math.min(dp[i][k] + dp[k][j], dp[i][j]);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(s == i)
                continue;
            //접점을 돌면서 최소값 찾기
            answer = Math.min(answer, Math.min(dp[s][i] + dp[i][a] + dp[i][b], dp[s][a] + dp[s][b]));
        }

        return answer;
    }

}
