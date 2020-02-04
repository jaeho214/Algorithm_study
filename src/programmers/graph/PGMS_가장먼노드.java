package programmers.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_가장먼노드 {

    public static void main(String[] args) {
        int[][] edge = {{3,6}, {4,3}, {3,2}, {1,3}, {1,2}, {2,4}, {5,2}};
        PGMS_가장먼노드 pgms_가장먼노드 = new PGMS_가장먼노드();
        System.out.println(pgms_가장먼노드.solution(6, edge));
    }

    public int solution(int n, int[][] edge) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n+1];
        boolean[][] hasEdge = new boolean[n+1][n+1]; //int 였는데 boolean 으로 바꿔주니 통과함
        int[] res = new int[n+1];

        for(int i=0;i<edge.length;i++){
            int first = edge[i][0];
            int second = edge[i][1];
            hasEdge[first][second] = hasEdge[second][first] = true;
        }

        q.add(1);
        res[1] = 1;
        visited[1] = true;

        while(!q.isEmpty()){
            int num = q.poll();
            for(int i=1;i<=n;i++){
                if(hasEdge[num][i] && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    res[i] = res[num] + 1;
                }
            }
        }
        int max = Arrays.stream(res).max().getAsInt();
        return (int) Arrays.stream(res).filter(i -> i==max).count();

    }
}
