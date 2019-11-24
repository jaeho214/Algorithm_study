package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BOJ_2667_단지번호붙이기 {
    private static boolean visited[][];
    private static int a[][];
    private static int n;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};
    private static PriorityQueue<Integer> pq;

    public static void main(String[] args) {
        input();
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                //반복문을 통해 sovle 실행. 중간에 0이 나와서 끊겨도 다음 부분부터 이어서 가능
                if(a[i][j] == 1 && !visited[i][j])
                    solve(i,j);
            }
        }
        System.out.println(pq.size());
        while(!pq.isEmpty()){
            System.out.println(pq.poll());
        }
    }

    private static void solve(int x, int y) {
        //미로 찾기와 똑같이 가다가
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();
        qx.add(x);
        qy.add(y);

        int cnt = 0;

        while(!qx.isEmpty() && !qy.isEmpty()){
            x = qx.poll();
            y = qy.poll();
            visited[x][y] = true;

            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX >= 0 && nextY >=0 && nextX <= n && nextY <= n){
                    if(a[nextX][nextY] == 1 && !visited[nextX][nextY]){
                        qx.add(nextX);
                        qy.add(nextY);
                        visited[nextX][nextY] = true;
                    }
                }
            }
            //cnt로 집의 개수를 찾고
            cnt++;

        }
        //모두 0이 나와 한 단지가 끝나면 우선순위 큐에 저장
        pq.offer(cnt);

    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());

            visited = new boolean[n+1][n+1];
            a = new int[n+1][n+1];
            pq = new PriorityQueue<Integer>();

            for(int i=1;i<=n;i++){
                String str = br.readLine();
                for(int j=1;j<=n;j++){
                    a[i][j] = str.charAt(j-1)-48;
                }
            }
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
