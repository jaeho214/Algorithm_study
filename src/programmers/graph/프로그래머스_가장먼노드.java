package programmers.graph;

import java.util.*;

public class 프로그래머스_가장먼노드 {
    public static void main(String[] args) {
        프로그래머스_가장먼노드 프로그래머스_가장먼노드 = new 프로그래머스_가장먼노드();
        int[][] vertex = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        프로그래머스_가장먼노드.solution(6, vertex);

    }
    List<List<Integer>> graph = new ArrayList<>();
    int[] dp;
    boolean[] visited;
    public int solution(int n, int[][] edge) {
        dp = new int[n+1];
        visited = new boolean[n+1];
        graphInit(n, edge);

        int max = findMax();

        return getMax(max);
    }

    private int getMax(int max){
        int answer = 0;
        for(int i=dp.length-1;i>=0;i--){
            if(max == dp[i])
                answer++;
        }
        return answer;
    }

    private int findMax(){
        int max = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while(!q.isEmpty()){
            int poll = q.poll();
            visited[poll] = true;

            for(int g : graph.get(poll)){
                if(visited[g]) continue;
                q.add(g);
                visited[g] = true;
                dp[g] = dp[poll]+1;
                max = Math.max(dp[g], max);
            }
        }
        return max;
    }

    private void graphInit(int n, int[][] edge){
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
    }
}
