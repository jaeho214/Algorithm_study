package boj.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://mygumi.tistory.com/361
 * 비트마스크를 이제 시작했다
 * 방문한 도시를 가지고 비트마스킹을 사용했다
 * 접근은 비슷하게 했지만 풀지 못했다
 * 너무 어렵다
 */
public class BOJ_2098_외판원순회 {
    static int[][] array;
    static int n;
    //dp[현재도시][방문한 도시]
    //dp[3][10] = 1,3번 도시를 방문하고 현재는 2번 도시에 있을 경우의 최소값
    static int[][] dp;
    static int INF = Integer.MAX_VALUE - 1000000;
    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solution(0,1));
    }

    //current는 현재 방문한 도시, visited 방문한 도시들의 비트값
    //예를 들어 현재 2번 도시를 방문하고 있고 1번도시와 3번 도시를 방문한 상태라면
    //current = 3, visited = 1010 = 10
    private static int solution(int current, int visited) {
        // 모두 방문했을 경우
        if ((visited == (1 << n) - 1)) {
            // 마지막 도시에서 0번 도시로 돌아갈 수 없을 경우.
            if (array[current][0] == 0) {
                return INF;
            }
            //마지막 도시로 돌아갈 수 있는 경우
            return array[current][0];
        }
        // 이미 방문한 적이 있다
        if (dp[current][visited] != 0) {
            return dp[current][visited];
        }

        dp[current][visited] = INF;
        for (int k = 0; k < n; k++) {
            int next = 1 << k;
            //& 연산자를 통해서 다음으로 방문할 도시의 비트가 켜져있는지를 확인한다
            //즉 방문했는지 여부를 판단
            if (array[current][k] == 0 || (visited & next) > 0) {
                // 갈 수 없거나, 방문했다면 건너뜀.
                continue;
            }
            // 현재 도시(current)에서 방문한 도시들(visited) 일때 도시 전체를 순회한 최소 비용.
            // 현재도시에서 이동할 수 있는 다음 도시들 중에 가장 적은 비용이 드는 도시로 이동
            dp[current][visited] = Math.min(dp[current][visited], solution(k, visited | next) + array[current][k]);
        }
        return dp[current][visited];
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        dp = new int[n][1<<n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }
}
