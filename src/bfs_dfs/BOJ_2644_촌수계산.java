package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2644_촌수계산 {
    private static int n,a,b,m;
    private static boolean visited[];
    private static int fam[][];
    private static int res[];
    public static void main(String[] args) {
        input();
        bfs(a);

        if(res[b] == 0)
            System.out.println("-1");
        else
            System.out.println(res[b]);
    }

    private static void bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);

        while(!q.isEmpty()){
            num = q.poll();
            visited[num] = true;
            for(int i=1;i<=n;i++){
                if(fam[num][i] == 1 && !visited[i]){
                    q.add(i);
                    res[i] = res[num] + 1;
                }
            }
        }
    }

    private static void input() {
        StringTokenizer st = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            fam = new int[n+1][n+1];
            visited = new boolean[n+1];
            res = new int[n+1];
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(br.readLine());
            for(int i=1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                fam[x][y] = fam[y][x] = 1;
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
