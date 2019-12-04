package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * m,n이 헷갈렸던 것 빼곤 단지번호붙이기 문제와 동일했음
 */
public class BOJ_1012_유기농배추 {
    private static boolean visited[][];
    private static int map[][];
    private static int m,n,k,count;
    private static int dx[] = {0,1,0,-1};
    private static int dy[] = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st1.nextToken());
            n = Integer.parseInt(st1.nextToken());
            k = Integer.parseInt(st1.nextToken());
            map = new int[n+1][m+1];
            visited = new boolean[n+1][m+1];
            count = 0;
            for(int j=1;j<=k;j++){
                StringTokenizer st2 = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());
                map[b][a] = 1;
            }
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    //이미 확인한 경로를 넘어가는 조건은 깜빡했었음 !visited[j][l]
                    if(map[j][l] == 1 && !visited[j][l]){
                        dfs(j,l);
                        count++;
                    }

                        //bfs(j,l);
                }
            }
            System.out.println(count);
        }
    }

    private static void dfs(int x, int y){
        visited[x][y] = true;
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextX < n && nextY >= 0 && nextY < m){
                if(map[nextX][nextY]==1 && !visited[nextX][nextY]){
                    dfs(nextX, nextY);
                }
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
            visited[x][y] = true;

            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < m){
                    if(map[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        qx.add(nextX);
                        qy.add(nextY);
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
        count++;
    }
}
