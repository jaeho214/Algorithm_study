package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 생각했던 방식이 다 맞았는데 코딩을 못했다...
 */
public class BOJ_3055_탈출 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int r,c, cnt;
    static char[][] arr;
    static Queue<Location> qs = new LinkedList<>();
    static Queue<Location> water = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        input();
        cnt = 0;
        bfs(arr);

        System.out.println(cnt);
    }

    private static void bfs(char[][] map) {
        while (true){
            cnt ++;
            //먼저 물을 채우고
            int size = water.size();
            for(int i=0;i<size; i++){
                Location l = water.poll();

                for(int j=0;j<4;j++){
                    int nx = l.x + dx[j];
                    int ny = l.y + dy[j];

                    if(nx >=1 && ny >= 1 && nx <= r && ny <= c){
                        if(arr[nx][ny] == '.'){
                            arr[nx][ny] = '*';
                            water.add(new Location(nx,ny));
                        }
                    }
                }
            }
            //고슴도치가 갈 곳이 없으면 불가능
            if(qs.size() == 0){
                System.out.println("KAKTUS");
                System.exit(0);
            }
            //고슴도치 이동
            int size2 = qs.size();
            for(int i=0;i<size2;i++){
                Location l = qs.poll();
                for(int j=0;j<4;j++){
                    int nx = l.x + dx[j];
                    int ny = l.y + dy[j];
                    if(nx >=1 && ny >= 1 && nx <= r && ny <= c){
                        if(map[nx][ny] == 'D')
                            return;

                        if(map[nx][ny] == '.'){
                            map[nx][ny] = 'S';
                            qs.add(new Location(nx, ny));
                        }
                    }
                }
            }
        }

    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r+1][c+1];
        for(int i=1;i<=r;i++){
            String str = br.readLine();
            for(int j=1;j<=c;j++){
                arr[i][j] = str.charAt(j-1);
                if(arr[i][j] == '*')
                    water.add(new Location(i,j));
                if(arr[i][j] == 'S')
                    qs.add(new Location(i,j));
            }
        }
        br.close();
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
