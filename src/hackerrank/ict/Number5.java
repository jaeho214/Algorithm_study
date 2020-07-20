package hackerrank.ict;

import java.util.ArrayList;
import java.util.List;

public class Number5 {
    public static void main(String[] args) {
        String[] arr = {"1 2","1 3", "2 4", "3 5", "7 8"};
        List<String> list = new ArrayList<>();
        for(String a : arr)
            list.add(a);
        System.out.println(connectedSum(100000, list));
    }


    static boolean[] visited;
    static List<List<Integer>> graph = new ArrayList<>();
    static int cnt=1;
    public static int connectedSum(int n, List<String> edges){
        visited = new boolean[n];

        graphInit(n);

        int answer = 0;
        for(String edge : edges){
            String[] s = edge.split(" ");
            graph.get(Integer.parseInt(s[1])-1).add(Integer.parseInt(s[0])-1);
            graph.get(Integer.parseInt(s[0])-1).add(Integer.parseInt(s[1])-1);
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer += Math.ceil(Math.sqrt(cnt));
            }
            cnt = 1;
        }
        return answer;
    }

    private static void dfs(int n){
        if(visited[n])
            return ;

        visited[n] = true;

        for(int node : graph.get(n)){
            if(visited[node])
                continue;
            cnt++;
            dfs(node);
        }

    }

    private static void graphInit(int n){
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
    }
}
