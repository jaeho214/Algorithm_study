package programmers.graph;

import java.util.*;

public class PGMS_순위 {
    public static void main(String[] args) {
        PGMS_순위 pgms_순위 = new PGMS_순위();
        int[][] results = {{1,2},{1,3}};
        System.out.println(pgms_순위.solution(3, results));
    }

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
