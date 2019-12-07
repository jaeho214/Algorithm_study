package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * https://qlyh8.tistory.com/156
 */
public class BOJ_7569_토마토 {
    private static final int GROW = 1;
    private static final int YET = 0;
    private static int m,n,h;
    private static int box[][][];
    private static boolean visited[][][];
    //3차원 배열일때 이렇게 해줘야한다는 것을 생각하지 못함
    private static int[] dx = {0, 1, 0, -1, 0, 0};
    private static int[] dy = {1, 0, -1, 0, 0, 0};
    private static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Integer> qx = new LinkedList<>();
    static Queue<Integer> qy = new LinkedList<>();
    static Queue<Integer> qz = new LinkedList<>();

    public static void main(String[] args) {
        input();
        for(int i=1;i<=h;i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (box[i][j][k] == GROW && !visited[i][j][k]){
                        //익어있는 곳을 먼저 다 큐에 넣어놓고 시작
                        //그냥 순서대로 꺼내면 첫번째 익은 토마토로만 bfs를 돌기때문에 이 방법을 사용해주어야 함
                        qx.add(j);
                        qy.add(k);
                        qz.add(i);
                    }
                }
            }
        }
        bfs();
        int count = 0;
        for(int i=1;i<=h;i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= m; k++) {
                    if (box[i][j][k] == YET) {
                        System.out.println("-1");
                        return;
                    }
                    if (count < box[i][j][k]) {
                        count = box[i][j][k];
                    }
                }
            }
        }
        //기본적으로 1에서 더해줬기 때문에 마지막에 -1
        System.out.println(count - 1);
    }

    private static void input(){
        StringTokenizer st = null;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            box = new int[h+1][n+1][m+1];
            visited = new boolean[h+1][n+1][m+1];

            for(int i=1;i<=h;i++){
                for(int j=1;j<=n;j++){
                    st = new StringTokenizer(br.readLine());
                    for(int k=1;k<=m;k++){
                        box[i][j][k] = Integer.parseInt(st.nextToken());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void bfs(){

        while(!qx.isEmpty() && !qy.isEmpty() && !qz.isEmpty()) {
            int x = qx.poll();
            int y = qy.poll();
            int z = qz.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                int nextZ = z + dz[i];

                if (nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= m && nextZ >= 1 && nextZ <= h) {
                    if (!visited[nextZ][nextX][nextY] && box[nextZ][nextX][nextY] == YET) {
                        qx.add(nextX);
                        qy.add(nextY);
                        qz.add(nextZ);
                        visited[nextZ][nextX][nextY] = true;
                        //익어갈때마다 1씩 추가
                        box[nextZ][nextX][nextY] = box[z][x][y] + 1;
                    }
                }
            }

        }

    }

}
