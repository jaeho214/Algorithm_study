package boj.bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2178_미로탐색_second {
    static int n,m;
    static int arr[][];
    static boolean[][] visited;
    static int[][] res;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        input();

        solve();

        output();
    }

    public static class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void solve() {
        visited = new boolean[n][m];
        res = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, 0));

        while(!q.isEmpty()){
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= m)
                    continue;
                if(visited[nextX][nextY] || arr[nextX][nextY] == 0)
                    continue;

                visited[nextX][nextY] = true;
                q.add(new Pair(nextX, nextY));
                res[nextX][nextY] = res[x][y] + 1;
            }
        }

    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res[n-1][m-1] + 1 + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[n][m];
        for(int i=0;i<n;i++){
            String s = br.readLine();
            for(int j=0;j<s.length();j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
    }
}
