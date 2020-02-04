package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2589_보물 {
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};
    static int n, m;
    static int result[][];
    static char arr[][];
    static boolean visited[][];
    static Queue<Location> q;

    public static void main(String[] args) throws IOException {
        int max = 0;
        input();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i][j] == 'L') {
                    q = new LinkedList<>();
                    visited = new boolean[n + 1][m + 1];
                    result = new int[n + 1][m + 1];
                    bfs(new Location(i, j));
                    //최대값을 구해야하는게 계속 할당만 해서 틀렸었음
                    max = Math.max(getMax(), max);
                }
            }
        }

        System.out.println(max);
    }

    private static int getMax(){
        int max = 0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(result[i][j] > max)
                    max = result[i][j];
            }
        }
        return max;
    }

    private static void bfs(Location location) {
        q.add(location);
        visited[location.x][location.y] = true;
        while(!q.isEmpty()){
            location = q.poll();
            for(int i=0;i<4;i++){
                int nextX = location.x + dx[i];
                int nextY = location.y + dy[i];
                if(nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= m){
                    if(arr[nextX][nextY] == 'L' && !visited[nextX][nextY]){
                        q.add(new Location(nextX, nextY));
                        visited[nextX][nextY] = true;
                        result[nextX][nextY] = result[location.x][location.y] + 1;
                    }
                }
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n+1][m+1];
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = str.charAt(j-1);
            }
        }
    }

    static class Location{
        int x;
        int y;
        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
