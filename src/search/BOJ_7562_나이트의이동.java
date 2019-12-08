package search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_7562_나이트의이동 {
    private static int dx[] = {2,1,-1,-2,-2,-1,1,2};
    private static int dy[] = {-1,-2,-2,-1,1,2,2,1};
    private static int t,n;
    private static boolean visited[][];
    private static int arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++) {
            n = Integer.parseInt(br.readLine());
            visited = new boolean[n][n];
            arr = new int[n][n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int fromX = Integer.parseInt(st.nextToken());
            int fromY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());
            bfs(fromX, fromY, toX, toY);
            System.out.println(arr[toX][toY]);
        }
    }

    private static void bfs(int fromX, int fromY, int toX, int toY) {
        if(fromX == toX && fromY == toY)
            return;

        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(fromX);
        qy.add(fromY);

        while(!qx.isEmpty() && !qy.isEmpty()){
            fromX = qx.poll();
            fromY = qy.poll();

            for(int i=0;i<8;i++){
                int nextX = fromX + dx[i];
                int nextY = fromY + dy[i];
                if(nextX >= 0 && nextY >= 0 && nextX < n && nextY < n){
                    if(!visited[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        qx.add(nextX);
                        qy.add(nextY);
                        arr[nextX][nextY] = arr[fromX][fromY] + 1;
                        if(nextX == toX && nextY == toY)
                            return;
                    }
                }
            }
        }
    }
}
