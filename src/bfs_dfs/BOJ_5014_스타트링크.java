package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_5014_스타트링크 {
    static int f,s,g,u,d, res[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        input();
        bfs(s);
        System.out.println("use the stairs");
    }

    private static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        while(!q.isEmpty()){
            x = q.poll();
            visited[x] = true;
            int up = x + u;
            int down = x - d;
            if(up<=f) {
                if (!visited[up]) {
                    visited[up] = true;
                    q.add(up);
                    res[up] = res[x] + 1;
                }
            }
            if(down >= 1) {
                if (!visited[down]) {
                    visited[down] = true;
                    q.add(down);
                    res[down] = res[x] + 1;
                }
            }
            if(visited[g]) {
                System.out.println(res[g]);
                System.exit(0);
            }

        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        visited = new boolean[f+1];
        res = new int[f+1];
    }
}
