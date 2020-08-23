package programmers.level3;

import java.util.ArrayList;
import java.util.Arrays;

public class Level3_배달 {
    public static void main(String[] args) {
        Level3_배달 level3_배달 = new Level3_배달();
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        System.out.println(level3_배달.solution(5, road, 3));
    }
    private ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
    private int[] result;
    private int K, answer=1;
    public int solution(int N, int[][] road, int K) {
        this.K = K;
        result = new int[N+1];
        Arrays.fill(result, Integer.MAX_VALUE);

        graphInit(N, road);
        dfs(1, 0);
        return answer;
    }

    private void dfs(int n, int weight){
        result[n] = weight;

        for(int[] node : graph.get(n)){
            int sum = node[1] + weight;
            if(K < sum || result[node[0]] < sum)
                continue;
            if(result[node[0]] == Integer.MAX_VALUE)
                answer++;
            dfs(node[0], node[1] + weight);
        }

    }

    public void graphInit(int N, int[][] road){
        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<road.length;i++) {
            graph.get(road[i][0]).add(new int[]{road[i][1],road[i][2]});
            graph.get(road[i][1]).add(new int[]{road[i][0],road[i][2]});
        }
    }

}
