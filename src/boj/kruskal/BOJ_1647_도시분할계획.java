package boj.kruskal;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BOJ_1647_도시분할계획 {
    public static class Graph{
        int node1;
        int node2;
        int edge;

        public Graph(int node1, int node2, int edge) {
            this.node1 = node1;
            this.node2 = node2;
            this.edge = edge;
        }
    }
    private static List<Graph> nodeList = new ArrayList<>();
    private static int house;
    private static int[] parent;
    private static int result;
    public static void main(String[] args) throws IOException {
        input();

        nodeList.sort((o1, o2) -> {
            if(o1.edge > o2.edge)
                return 1;
            else if(o1.edge < o2.edge)
                return -1;
            else
                return 0;
        });

        int cnt = 0;
        for(Graph g : nodeList){
            if(isCycle(g.node1, g.node2))
                continue;
            unionParent(g.node1, g.node2);
            result += g.edge;
            cnt++;
            if(cnt == house-2)
                break;
        }

        output();
    }

    private static boolean isCycle(int node1, int node2){
        return findParent(node1) == findParent(node2);
    }

    private static void unionParent(int node1, int node2){
        node1 = findParent(node1);
        node2 = findParent(node2);

        parent[node1] = node2;
    }

    private static int findParent(int search) {
        if(parent[search] == search) return search;

        return parent[search] = findParent(parent[search]);
    }


    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        house = Integer.parseInt(str[0]);
        parent = new int[house+1];

        for(int i=1;i<parent.length;i++){
            parent[i] = i;
        }

        for(int i=0;i<Integer.parseInt(str[1]);i++){
            String[] nodes = br.readLine().split(" ");
            nodeList.add(new Graph(Integer.parseInt(nodes[0]), Integer.parseInt(nodes[1]), Integer.parseInt(nodes[2])));
        }

    }
}
