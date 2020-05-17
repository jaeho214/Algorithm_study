package boj.bfs_dfs;

import java.io.*;
import java.util.*;

public class BOJ_2667_단지번호붙이기_second {
    static List<Integer> res = new ArrayList<>();
    static int n;
    static int[][] arr;
    static boolean[][] visited;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        input();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1 && !visited[i][j]) {
                    res.add(solve(i, j));
                }
            }
        }

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

    private static int solve(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));

        int count = 0;

        while(!q.isEmpty()){
            Pair poll = q.poll();
            x = poll.x;
            y = poll.y;
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= n || ny < 0 || ny >= n)
                    continue;
                if(visited[nx][ny] || arr[nx][ny] == 0)
                    continue;

                q.add(new Pair(nx, ny));
                visited[nx][ny] = true;
            }
            count ++;
        }

        return count;
    }

    private static void output() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(res.size() + "\n");
        Collections.sort(res);
        for(int r : res){
            bw.write(r + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        br.close();
    }
}
