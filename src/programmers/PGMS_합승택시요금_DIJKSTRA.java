package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PGMS_합승택시요금_DIJKSTRA {
    public static void main(String[] args) {
        PGMS_합승택시요금_DIJKSTRA pgms_합승택시요금_dijkstra = new PGMS_합승택시요금_DIJKSTRA();
        int[][] fares = {{4,1,10}, {3,5,24}, {5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}};
        System.out.println(pgms_합승택시요금_dijkstra.solution(6,4,6,2,fares));
    }

    List<List<Edge>> graph;
    private class Edge implements Comparable<Edge>{
        int next;
        int cost;

        public Edge(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    private void graphInit(int n){
        graph = new ArrayList<>();
        for(int i=0;i<n;i++)
            graph.add(new ArrayList<>());
    }

    public int solution(int n, int s, int a, int b, int[][] fares){
        int answer = Integer.MAX_VALUE;

        graphInit(n);

        for(int[] fare : fares){
            graph.get(fare[0]-1).add(new Edge(fare[1]-1, fare[2]));
            graph.get(fare[1]-1).add(new Edge(fare[0]-1, fare[2]));
        }

        int startA[] = new int[n];
        int startB[] = new int[n];
        int start[] = new int[n];

        Arrays.fill(startA, 100000*n);
        Arrays.fill(startB, 100000*n);
        Arrays.fill(start, 100000*n);

        //A에서 시작하고
        startA = dijkstra(a-1, startA);
        //B에서 시작하고
        startB = dijkstra(b-1, startB);
        //S에서 시작해서 정점간의 최소거리를 구하고
        start = dijkstra(s-1, start);

        //중간에 A 경로와 B 경로와 S 경로의 접점을 비교하여 최소값을 찾는다.
        for(int i=0;i<n;i++)
            answer = Math.min(answer, startA[i] + startB[i] + start[i]);

        return answer;
    }

    private int[] dijkstra(int start, int[] cost) {
        PriorityQueue<Edge> pq = new PriorityQueue<>(graph.get(start));

        for(Edge e : graph.get(start))
            cost[e.next] = e.cost;

        cost[start] = 0;

        while(!pq.isEmpty()){
            Edge current = pq.poll();

            //비용이 더 적다면 굳이 확인할 필요 없잖아?
            if(cost[current.next] < current.cost)
                continue;

            //비용이 더 적은것을 찾아 우선순위 큐에 넣어주자
            for(Edge next : graph.get(current.next)){
                if(cost[next.next] > current.cost + next.cost){
                    cost[next.next] = current.cost + next.cost;
                    pq.add(new Edge(next.next, cost[next.next]));
                }
            }
        }

        return cost;
    }
}
