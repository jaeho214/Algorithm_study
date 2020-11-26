package programmers.graph;

import java.util.*;

public class 프로그래머스_순위 {
    public static void main(String[] args) {
        프로그래머스_순위 프로그래머스_순위 = new 프로그래머스_순위();
        int[][] results = {{4,3}, {4,2}, {3,2}, {1,2}, {2,5}};
        System.out.println(프로그래머스_순위.solution(5, results));
    }

    public class Score{
        int win;
        int lose;
        public Score() {
            this.win = 0;
            this.lose = 0;
        }

        public Score addWin(){
            this.win++;
            return this;
        }

        public Score addLose(){
            this.lose++;
            return this;
        }

        public boolean isComplete(int n){
            return this.win+this.lose == n-1;
        }
    }
    List<List<Integer>> graph = new ArrayList<>();
    int total = 0;
    int answer = 0;
    Map<Integer, Score> map = new HashMap<>();
    public int solution(int n, int[][] results) {
        this.total = n-1;

        graphInit(n, results);
        mapInit(n);

        for(int i=1;i<=n;i++){
            boolean[] visited = new boolean[n+1];
            rank(i, i, visited);
        }

        List<Integer> result = new ArrayList<>(map.keySet());
        for(int r : result){
            if(map.get(r).isComplete(n))
                answer++;
        }
        return answer;
    }

    private void mapInit(int n) {
        for(int i=1;i<=n;i++){
            map.put(i, new Score());
        }
    }

    private void rank(int winner, int loser, boolean[] visited) {
        if(visited[loser])
            return;

        visited[loser] = true;
        for(int node : graph.get(loser)){
            if(visited[node])
                continue;
            map.put(node,map.get(node).addLose());
            map.put(winner,map.get(winner).addWin());
            rank(winner, node, visited);
        }
    }

    private void graphInit(int n, int[][] results){
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] result : results) {
            graph.get(result[0]).add(result[1]);
        }
    }

}
