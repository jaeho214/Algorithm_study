package search;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * https://kim6394.tistory.com/201
 * 결국 시간초과를 해결하지 못했다,,
 */
public class BOJ_2206_벽부수고이동하기 {
    static int dx[] = {-1,0,1,0};
    static int dy[] = {0,-1,0,1};
    static int n,m,res;
    static int[][] arr,visited;

    public static void main(String[] args) throws IOException {
        input();
        bfs(1,1);

        if(res == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(res);
    }

    private static void bfs(int x, int y) {
        Queue<Place> q = new LinkedList<>();
        q.add(new Place(x,y,1,0));
        visited[x][y] = 0;

        while(!q.isEmpty()){
            Place p = q.poll();
            if(p.x == n && p.y == m){
                res = p.dis;
                return;
            }
            for(int i=0;i<4;i++){
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];
                if(nextX >= 1 && nextY >= 1 && nextX <= n && nextY <= m){
                    //공사여부로 방문여부를 판단
                    //visited값이 현재까지 공사수보다 크면 방문을 아직 안한것으로 간주
                    //다음칸이 길이면
                    if(visited[nextX][nextY] > p.drill && arr[nextX][nextY] == 0){
                        //현재 공사 횟수를 visited에 넣고 방문한 것으로 체크
                        visited[nextX][nextY] = p.drill;
                        //거리를 하나 늘려서 큐에 저장
                        q.add(new Place(nextX,nextY, p.dis+1, p.drill));
                        //방문을 아직 안했는데 다음 칸이 벽이면
                    }else if(visited[nextX][nextY] > p.drill && arr[nextX][nextY] == 1){
                        //아직 공사를 하기 전이면
                        if(p.drill == 0){
                            //공사를 진행하여 방문 체크
                            visited[nextX][nextY] = p.drill + 1;
                            //공사를 하고 거리를 늘려서 큐에 저장
                            //여기서 이미 공사 횟수를 늘려서 큐에 저장하므로 visited가 1이고 p.drill이 1일 경우가 없음
                            q.add(new Place(nextX,nextY,p.dis+1, p.drill+1));
                        }
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
        arr = new int[n+1][m+1];
        visited = new int[n+1][m+1]; // 공사의 횟수
        for(int i=1;i<=n;i++){
            String str = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = str.charAt(j-1) - '0';
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        res = Integer.MAX_VALUE;
        br.close();
    }
    static class Place{
        int x;
        int y;
        int dis;
        int drill;

        public Place(int x, int y, int dis, int drill) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.drill = drill;
        }
    }
}
