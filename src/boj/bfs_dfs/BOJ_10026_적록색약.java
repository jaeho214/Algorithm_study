package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_10026_적록색약 {
    private static int dx[] = {1,0,-1,0};
    private static int dy[] = {0,-1,0,1};
    private static int n;
    private static char color[][];
    private static boolean visited[][];

    public static void main(String[] args) {
        int res1 = 0, res2 = 0;
        input();
/*bfs
        //적록색약이 아닌 경우
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(!visited[i][j]) {
                    res1++;
                    bfs(i, j);
                }
            }
        }
        setColor();
        visited = new boolean[n+1][n+1];
        //적록색약인 경우
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(!visited[i][j]) {
                    res2++;
                    bfs(i, j);
                }
            }
        }
*/
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(!visited[i][j]) {
                    res1 ++;
                    dfs(i, j);
                }
            }
        }
        setColor();
        visited = new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(!visited[i][j]) {
                    res2 ++;
                    dfs(i, j);
                }
            }
        }
        System.out.print(res1 + " " + res2);

    }
    //적록색약 결과를 위해 G를 R로 통일
    private static void setColor(){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(color[i][j] == 'G')
                    color[i][j] = 'R';
            }
        }
    }
    private static void bfs(int x, int y) {
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 1 && nextY >=1 && nextX <= n && nextY <=n){
                    if(!visited[nextX][nextY] && color[x][y]==color[nextX][nextY]){
                        qx.add(nextX);
                        qy.add(nextY);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
    private static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 1 && nextY >=1 && nextX <= n && nextY <=n){
                if(!visited[nextX][nextY] && color[x][y]==color[nextX][nextY]){
                    dfs(nextX,nextY);
                }
            }
        }
    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            color = new char[n+1][n+1];
            visited = new boolean[n+1][n+1];
            for(int i=1;i<=n;i++){
                String str = br.readLine();
                for(int j=1;j<=n;j++){
                    color[i][j] = str.charAt(j-1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
