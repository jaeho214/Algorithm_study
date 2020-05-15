package boj.bfs_dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ_1260_DFS와BFS {
    static int n,m,v;
    static int arr[][];
    static boolean[] visited;
    static List<Integer> dfsList = new ArrayList<>();
    static List<Integer> bfsList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        //input
        input();

        //dfs
        visited = new boolean[n+1];
        dfsList.add(v);
        dfs(v);

        //bfs
        visited = new boolean[n+1];
        bfsList.add(v);
        bfs();

        //output
        output();
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);

        while(!q.isEmpty()){
            int v = q.poll();
            visited[v] = true;
            for(int i=1;i<=n;i++){
                if(visited[i])
                    continue;
                if(arr[v][i] == 1){
                    bfsList.add(i);
                    visited[i] = true;
                    q.add(i);
                }
            }
        }

    }

    private static void dfs(int v) {
        if(visited[v])
            return ;

        visited[v] = true;

        for(int i=1;i<=n;i++){
            if(visited[i])
                continue;
            if(arr[v][i] == 1){
                dfsList.add(i);
                dfs(i);
            }
        }
    }

    private static void output() throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i : dfsList){
            bw.write(i + " ");
        }
        bw.write("\n");
        for(int i : bfsList){
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str[] = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);
        v = Integer.parseInt(str[2]);
        arr = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            String s[] = br.readLine().split(" ");
            arr[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
            arr[Integer.parseInt(s[1])][Integer.parseInt(s[0])] = 1;
        }
        br.close();
    }
}
