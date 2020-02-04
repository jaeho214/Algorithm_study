package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
 * 그냥 위아래로 뒤집어서 생각하면 됨
 * 색칠 처리를 해주는게 관건
 * https://bcp0109.tistory.com/53
 */
public class BOJ_2583_영역구하기 {
    private static int m,n,k;
    private static int a[][];
    private static int area;
    private static int[] dx = {0,1,0,-1};
    private static int[] dy = {1,0,-1,0};

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int count = 0;

        input();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //너비를 계속 0으로 초기화
                area = 0;
                //색칠 되어있지 않으면
                if(a[i][j] == 0) {
                    //한번 카운트 하고
                    count ++;
                    //dfs를 통해 색칠하며 너비를 구하고
                    dfs(i, j);
                    //큐에 너비 저장
                    pq.offer(area);
                }
            }
        }

        System.out.println(count);
        while(!pq.isEmpty())
            System.out.print(pq.poll() + " ");

    }

    private static void dfs(int x, int y) {
        //색칠되지 않은 부분을 색칠하고
        a[x][y] = 1;
        //너비를 구함
        area ++;

        //dfs로 상하좌우 들어가서 색칠되어있지 않은 곳을 찾음
        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if(nextX >= 0 && nextY >= 0 && nextX < m && nextY < n){
                if(a[nextX][nextY] == 0)
                    dfs(nextX,nextY);
            }

        }
    }


    //입력받는 수를 int형으로 변환 시켜주는 메소드
    private static int stoi(String s){return Integer.parseInt(s);}


    private static void input() {
        StringTokenizer st = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            m = stoi(st.nextToken());
            n = stoi(st.nextToken());
            k = stoi(st.nextToken());
            a = new int[m + 1][n + 1];

            for (int i = 1; i <= k; i++) {
                st = new StringTokenizer(br.readLine());
                //입력 받는대로 색칠을 실행함
                setSquare(stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()), stoi(st.nextToken()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //예를 들어 (0,2) ~ (4,4)를 색칠하면
    //세로(y)로 2~3(4-1)까지 칠하고 가로(x)로 0부터 3(4-1)까지 칠함
    //상하 반전을 하고 색칠함
    private static void setSquare(int x1, int y1, int x2, int y2) {
        for(int i=y1; i< y2; i++){
            for(int j=x1; j<x2; j++){
                a[i][j] = 1;
            }
        }
    }
}
