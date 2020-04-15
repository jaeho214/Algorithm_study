package programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.Arrays;

public class PGMS_배달 {
    public static void main(String[] args) {
        PGMS_배달 pgms_배달 = new PGMS_배달();
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,3},{3,5,2},{5,6,1}};
        System.out.println(pgms_배달.solution(6, road, 4));
    }
    //인접 리스트
    private ArrayList<ArrayList<int[]>> listGraph = new ArrayList<>();
    private int[] visited;
    //1번은 무조건 배달 가능 하니까 초기값 1로 세팅
    int answer = 1;
    public int solution(int N, int[][] road, int K) {
        visited = new int[N+1];
        Arrays.fill(visited, Integer.MAX_VALUE);

        for(int i=0;i<N+1;i++){
            listGraph.add(new ArrayList<>());
        }

        for(int i=0;i<road.length;i++) {
            //int[]로 인접 리스트를 만들고 [0]에는 노드, [1]에는 가중치를 넣어준다.
            listGraph.get(road[i][0]).add(new int[]{road[i][1],road[i][2]});
            listGraph.get(road[i][1]).add(new int[]{road[i][0],road[i][2]});
        }

        //1번부터 dfs 시작
        dfs(1, 0, K);
        return answer;
    }

    private void dfs(int current, int price, int k){
        //현재 노드에 현재까지의 가중치를 넣어준다.
        visited[current] = price;

        //현재 노드와 연결된 노드들을 돌면서
        for(int[] next : listGraph.get(current)){
            //가중치에 current까지의 가중치를 더했을 때 k를 넘어가거나
            //이미 저장된 next[0]까지의 가중치를 넘어가면(이미 저장된 비용보다 크다면)
            //즉 배달이 불가하다면
            if(k < next[1] + price || visited[next[0]] <  next[1] + price)
                //무시
                continue;
            //아직 방문하지 않은 노드라면
            if(visited[next[0]] == Integer.MAX_VALUE)
                //배달 가능하므로 answer++
                answer ++;
            dfs(next[0], next[1] + price, k);
        }

    }
}
