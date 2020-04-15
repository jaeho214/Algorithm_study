### 문제
https://programmers.co.kr/learn/courses/30/lessons/12978

### 접근법
저음에는 효율성 테스트가 없길래 인접 행렬을 사용하여 전체를 순회하는 dfs로 진행하였는데 역시나 시간초과가 났다.   
그래서 map를 사용하기, 정렬해서 풀기 등 O(n)의 시간복잡도로 풀기위해서 노력해보았으나 힘들었다.   
정답은 인접리스트를 사용하여 dfs로 푸는 것이었다.(다익스트라)   
가중치도 인접리스트에 포함을 시켜야 하기 때문에 int[]를 사용하였다.
dfs 탐색시에 방문했던 마을이라고 무조건 안가는 것이 아니라 값을 체크해서 가장 작은 값이 들어갈 수 있도록 한다.   
그렇기 때문에 방문 초기값은 큰 수이어야 한다.


### 코드
```
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
```