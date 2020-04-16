### 문제
https://programmers.co.kr/learn/courses/30/lessons/49191

### 접근법
처음에는 정렬을 통해서 모든 선수와 경기를 마친 선수를 찾고 그 선수를 기준으로 찾아보려고 하였는데 답을 찾지 못했다.   
이 문제의 카테고리가 그래프여서 방향 그래프로 접근을 하였다.   
A 선수가 B 선수를 이겼을 경우에 A -> B 이런식으로 방향 그래프를 구성하였고,   
모든 선수들을 순회하면서 해당 선수와 엮여있는 선수들을 찾아서 승 패를 기록하였다.   
선수가 최대 100명이라 다 돌아도 되겠다고 판단했다.   
예를 들어 1번이 2번을 이기고 2번이 3번을 이겼을 경우에 1번과 3번은 경기를 하지 않았지만 1번이 3번을 이긴다는 것을 알 수 있다.   
모든 선수를 순회하고 나면 1번은 2승 0패로 기록이 되므로 1번이 1등이란 사실은 알 수 있게 된다.


### 코드
```
import java.util.*;

public class PGMS_순위 {
    public class History{
        int win;
        int lose;

        public History() {
            this.win = 0;
            this.lose = 0;
        }

        public History addWin(){
            this.win++;
            return this;
        }
        public History addLose(){
            this.lose++;
            return this;
        }
    }

    List<List<Integer>> graph = new ArrayList<>();
    Map<Integer, History> map = new HashMap<>();

    public int solution(int n, int[][] results) {

        if(n == 1)
            return 1;

        int answer = 0;

        for(int i=1;i<=n;i++){
            map.put(i, new History());
        }

        graphInit(n, results);

        //모든 선수들을 순회하면서
        for(int i=0;i<graph.size();i++){
            boolean[] visited = new boolean[n+1];
            if(graph.get(i).size() == 0)
                continue;

            //일단 이 선수를 다시 확인하지 않도록 visited true 처리
            visited[i] = true;

            dfs(i, i, visited);
        }

        //모든 선수를 순회하면서 전적이 (모든 선수들의 수-1)이 되면 해당 선수의 순위를 정확히 매길 수 있다.
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            if(map.get(next).lose + map.get(next).win >= n-1){
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int winner, int num, boolean[] visited){
        if(graph.get(num).size() == 0)
            return;

        for(int node : graph.get(num)){
            //이미 대결을 펼쳐서 결과를 아는 선수라면 스킵
            if(visited[node])
                continue;
            visited[node] = true;
            //이긴 선수의 기록에 승수를 추가하고
            map.put(winner, map.get(winner).addWin());
            //패한 선수의 기록에 패수를 추가한다.
            map.put(node, map.get(node).addLose());

            dfs(winner, node, visited);
        }
    }

    private void graphInit(int n, int[][] results){
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] result : results){
            graph.get(result[0]).add(result[1]);
        }
    }
}

```