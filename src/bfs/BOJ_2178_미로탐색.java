package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2178_미로탐색 {
    private static boolean visited[][];
    private static int a[][];
    private static int n,m;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    public static void main(String[] args) {
        input();
        solve(1,1);
        System.out.println(a[n][m]);
    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            a = new int[n+1][m+1];
            visited = new boolean[n+1][m+1];

            for(int i=1;i<=n;i++){
                String str = br.readLine();
                for(int j=1;j<=m;j++){
                    a[i][j] = str.charAt(j-1) - 48;
                }
            }

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private static void solve(int x, int y){
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visited[x][y] = true;

            //한 곳을 기준으로 상하좌우를 다 방문
            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];

                if(nextX >= 0 && nextY >= 0 && nextX <= n && nextY <= m){
                    if(a[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        qx.add(nextX);
                        qy.add(nextY);
                        visited[nextX][nextY] = true;
                        a[nextX][nextY] = a[x][y] + 1;
                    }
                }
            }
        }

    }
}
