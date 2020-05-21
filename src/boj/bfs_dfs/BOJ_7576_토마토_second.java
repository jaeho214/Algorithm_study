package boj.bfs_dfs;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_7576_토마토_second {
    static int n,m;
    static int[][] arr;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int res[][];
    static boolean visited[][];
    static Queue<Pair> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        input();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] > 0){
                    q.add(new Pair(i,j));
                }
            }
        }
        solve();
        output();
    }

    private static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void solve() {

        while(!q.isEmpty()){
            Pair poll = q.poll();
            int x = poll.x;
            int y = poll.y;

            visited[x][y] = true;

            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= m || ny >= n || nx < 0 || ny < 0)
                    continue;
                if(visited[nx][ny] || arr[nx][ny] != 0)
                    continue;

                visited[nx][ny] = true;
                res[nx][ny] = res[x][y] + 1;
                q.add(new Pair(nx, ny));
            }
        }
    }

    private static void output() throws IOException {
        int max = 0;
        loop:
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(res[i][j] == 0 && arr[i][j] == 0){
                        max = -1;
                        break loop;
                    }
                    max = Math.max(res[i][j], max);
                }
            }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        n = Integer.parseInt(str[0]);
        m = Integer.parseInt(str[1]);

        arr = new int[m][n];
        res = new int[m][n];
        visited = new boolean[m][n];

        for(int i=0;i<m;i++){
            String s[] = br.readLine().split(" ");
            for(int j=0;j<s.length;j++){
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
    }
}
