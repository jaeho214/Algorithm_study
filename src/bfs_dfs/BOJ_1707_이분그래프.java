package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * https://stack07142.tistory.com/104
 * 인접리스트 사용이 미숙했다.
 */
public class BOJ_1707_이분그래프 {
    static final int RED = 1;
    static final int BLUE = -1;

    static boolean checkBipartite;

    public static void main(String[] args) throws IOException {

        int K; // 테스트케이스
        int V; // 정점의 개수
        int E; // 간선의 개수
        ArrayList<ArrayList<Integer>> graph;
        int[] color;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        for (int k = 0; k < K; k++) {

            // input
            StringTokenizer st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            color = new int[V + 1];
            graph = new ArrayList<ArrayList<Integer>>();

            //재귀를 끝낼 변수
            checkBipartite = true;

            for (int i = 0; i < V + 1; i++) {
                //색칠을 하기위해 다 0으로 비워주기
                Arrays.fill(color, 0);
                //그래프 초기화
                graph.add(new ArrayList<Integer>());
            }

            for (int e = 0; e < E; e++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                //그래프 연결
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            for (int i = 1; i < V + 1; i++) {

                //재귀를 끝내기 위한 조건
                if (!checkBipartite) {

                    break;
                }
                //색깔이 없으면
                if (color[i] == 0) {
                    //색칠해주기
                    dfs(i, RED, color, graph, V);
                }
            }

            System.out.println(checkBipartite ? "YES" : "NO");
        }

    }

    static void dfs(int node, int c, int[] color, ArrayList<ArrayList<Integer>> graph, int V) {
        //c 색깔로 색칠해주고
        color[node] = c;

        //현재 노드와 연결되어있는 노드들을 뒤지면서
        for (int adjNode : graph.get(node)) {
            // 같은 색깔이면
            if (color[adjNode] == c) {
                //종료 flag 켜기
                checkBipartite = false;
                return;
            }
            // 색깔이 비어있으면
            if (color[adjNode] == 0) {
                //재귀 호출
                dfs(adjNode, -c, color, graph, V);
            }
        }
    }
}




