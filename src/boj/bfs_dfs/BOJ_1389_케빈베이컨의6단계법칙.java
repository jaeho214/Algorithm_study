package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * https://2youngjae.tistory.com/14
 */
public class BOJ_1389_케빈베이컨의6단계법칙 {

    //현재 노드와 목적지까지의 거리 클래스
    public static class Node{
        int x;
        int dist;
        Node(int _x, int d){
            x=_x;
            dist=d;
        }
    }
    private static boolean visited[];
    private static int relation[][];
    private static int n,m;
    private static int res[];
    public static void main(String[] args) {
        input();

        int min = floyd_warshall();
        for(int i=1;i<=n;i++){
            //케빈베이컨이 최소값인 정점을 찾아서 출력하고 break
            if(res[i] == min){
                System.out.println(i);
                break;
            }
        }

        /*
        for(int i=1;i<=n;i++){
            visited = new boolean[n+1];
            bfs(i);
        }

        int min = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            if(res[i]<min){
                min = res[i];
            }
        }
        for(int i = 1 ; i<= n ; i++){
            if(res[i]==min){
                System.out.println(i);
                break;
            }
        }
         */

    }

    private static int floyd_warshall() {
        //중간 정점들을 거쳐 목저지까지 가는 최소값을 구하기
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                for(int k=1;k<=n;k++){
                    //j~k 로 가는 경로인데 i를 거쳐서 가는 것과 비교해서 작은 값을 넣어줌
                    if(relation[j][k] > relation[j][i] + relation[i][k])
                        relation[j][k] = relation[j][i] + relation[i][k];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        //정점을 모두 돌면서
        for(int i=1;i<=n;i++){
            int sum = 0;
            //정점에서 다른 정점으로 가는 경우의 수들의 합을 구함
            for(int j=1;j<=n;j++){
                sum += relation[i][j];
            }
            //그 합을 res 에 넣어주고
            res[i] = sum;
            //합들의 최솟값을 구함
            if(sum < min)
                min = sum;
        }

        //최솟값을 리턴
        return min;
    }
    private static void bfs(int num){
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(num, 0));
        visited[num] = true;
        while(!q.isEmpty()){
            num = q.peek().x;
            int dist = q.poll().dist;
            for(int i=1;i<=n;i++){
                if(relation[num][i] == 1 && !visited[i]){
                    //현재 정점과 인접한 정점들을 찾아서 dist + 1로 값 넣어줌
                    q.add(new Node(i, dist + 1));
                    visited[i] = true;
                    //현재 정점과 인접한 정점들까지의 거리를 res에 저장
                    res[i] += dist+1;
                }
            }
        }
    }


    private static void input() {
        StringTokenizer st = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            res = new int[n+1];
            relation = new int[n+1][n+1];

            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    relation[i][j] = (i==j)? 0: 9999999;
                }
            }

            for(int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                relation[a][b] = relation[b][a] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
