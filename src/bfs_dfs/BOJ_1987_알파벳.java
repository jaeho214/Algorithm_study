package bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1987_알파벳 {
    private static int dx[] = {1,0,-1,0};
    private static int dy[] = {0,-1,0,1};
    private static int r,c,res = 0;
    private static boolean visited[];
    private static char arr[][];
    private static int result[][];

    public static void main(String[] args) {
        input();
        dfs(1,1, 1);
        System.out.println(res);
    }

    //dfs로 카운트를 셀때는 파라미터로 cnt를 넣어주는듯
    private static void dfs(int x, int y, int cnt) {
        visited[arr[x][y] - '0'] = true;

        for(int i=0;i<4;i++){
            int nextX = x + dx[i];
            int nextY = y + dy[i];
            if(nextX >= 1 && nextY >= 1 && nextX <= r && nextY <=c){
                if(!visited[arr[nextX][nextY] - '0']){
                    dfs(nextX,nextY, cnt+1);
                    //계속 true값이어서 문제였는데 백트래킹으로 해결해줌
                    visited[arr[nextX][nextY] - '0'] = false;
                }
            }
        }
        res = Math.max(res,cnt);

    }

    private static void input() {
        BufferedReader br = null;
        StringTokenizer st = null;
        try{
            br = new BufferedReader(new InputStreamReader(System.in));
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            arr = new char[r+1][c+1];
            visited = new boolean[128];
            result = new int[r+1][c+1];
            result[1][1] = 1;
            for(int i=1;i<=r;i++){
                String str = br.readLine();
                for(int j=1;j<=c;j++){
                    arr[i][j] = str.charAt(j-1);
                }
            }


            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
