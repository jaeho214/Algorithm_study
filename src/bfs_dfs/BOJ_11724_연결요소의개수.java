package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11724_연결요소의개수 {
    private static boolean visited[];
    private static int a[][];
    private static int n,m;
    public static void main(String[] args) {
        int cnt=0;
        input();
        for(int i=1;i<=n;i++) {
            if (!visited[i]) {
                cnt++;
                //bfs(i);
                dfs(i);
            }
        }
        output(cnt);

    }

    private static void dfs(int num){
        visited[num] = true;
        for(int i=1;i<=n;i++){
            if(a[num][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        while(!q.isEmpty()){
            num = q.poll();
            visited[num] = true;
            for(int i=1;i<=n;i++){
                if(a[num][i] == 1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
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
            visited = new boolean[n+1];
            a = new int[n+1][n+1];
            for(int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());
                // 양쪽다 1로 체크해주어 방향성을 없애줌
                a[num1][num2] = 1;
                a[num2][num1] = 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void output(int cnt) {
        System.out.println(cnt);
    }
}
