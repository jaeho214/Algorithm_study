package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_11403_경로찾기 {
    private static boolean visited[];
    private static int result[][];
    private static int a[][];
    private static int n, number;
    public static void main(String[] args) {
        int n = input();
        for(int i=1;i<=n;i++) {
            visited = new boolean[n + 1];
            number = i;
            dfs(i);

        }
        output();
    }

    private static void dfs(int x){
        for(int i=1;i<=n;i++){
            if(a[x][i] == 1 && !visited[i]){
                visited[i] = true;
                result[x][i] = 1;
                result[number][i] = 1;
                dfs(i);
            }
        }
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        //visited를 계속 갱신하면서 해줄 생각을 못함
        visited = new boolean[n+1];
        q.add(num);
        while(!q.isEmpty()){
            int value = q.poll();
            for(int j=1;j<=n;j++){
                if(a[value][j] == 1 && !visited[j]){
                    q.add(j);
                    visited[j] = true;
                    result[num][j] = 1;
                }
            }
        }
    }

    private static void output() {
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            a = new int[n+1][n+1];
            result = new int[n+1][n+1];
            for(int i=1;i<=n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=1;j<=n;j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                }
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        return n;
    }
}
