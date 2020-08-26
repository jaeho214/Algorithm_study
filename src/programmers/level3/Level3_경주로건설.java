package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class Level3_경주로건설 {
    public static void main(String[] args) {
        Level3_경주로건설 level3_경주로건설 = new Level3_경주로건설();
        int[][] board = {{0,0,0,0,0,0}, {0,1,1,1,1,0}, {0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}};
        System.out.println(level3_경주로건설.solution(board));
    }
    private int[][] visited;
    private int answer = Integer.MAX_VALUE;
    int[] moveX = {-1,1,0,0};
    int[] moveY = {0,0,1,-1};
    public int solution(int[][] board) {
        visited = board.clone();

        //dfs(0,0,0,0,0);
        int res = bfs(board);
        return res;
    }

    public class Pair{
        int x;
        int y;
        int cost;
        int direction;

        public Pair(int x, int y, int cost, int direction) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.direction = direction;
        }
    }
    
    public int bfs(int[][] board){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, 0, -1));
        visited[0][0] = 1;

        while(!q.isEmpty()) {
            Pair pair = q.poll();
            int x = pair.x;
            int y = pair.y;
            int cost = pair.cost;
            int direction = pair.direction;

            if(x == board.length-1 && y == board.length-1){
                answer = Math.min(answer, cost);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x + moveX[i];
                int nextY = y + moveY[i];
                if (nextX >= board.length || nextX < 0 || nextY >= board.length || nextY < 0)
                    continue;
                if (visited[nextX][nextY] == 1)
                    continue;

                int nextCost = 0;
                if(direction == -1 || direction == i)
                    nextCost = cost + 100;
                else if(direction != i)
                    nextCost = cost + 600;

                if(visited[nextX][nextY] == 0 || visited[nextX][nextY] >= nextCost){
                    visited[nextX][nextY] = nextCost;
                    q.add(new Pair(nextX, nextY, nextCost, i));
                }

            }


        }
        return answer;
    }
 /* 시간 초과났던 dfs
    public void dfs(int x,int y, int beforeX,int straight, int corner){
        if(x == board.length-1 && y == board.length-1) {
            answer = Math.min(answer, (straight*100) + (corner*500));
            return;
        }

        if(x == 0 && y == 0){
            for(int i=1;i<3;i++){
                int nextX = x+moveX[i];
                int nextY = y+moveY[i];
                if(nextX >= board.length || nextX < 0 || nextY >= board.length || nextY < 0)
                    continue;
                if(board[nextX][nextY] > 0)
                    continue;
                if(visited[nextX][nextY])
                    continue;
                visited[nextX][nextY] = true;
                dfs(nextX, nextY, x, straight+1, corner);
                visited[nextX][nextY] = false;
            }
        }

        for(int i=0;i<4;i++){
            int nextX = x+moveX[i];
            int nextY = y+moveY[i];
            if(nextX >= board.length || nextX < 0 || nextY >= board.length || nextY < 0)
                continue;
            if(board[nextX][nextY] > 0)
                continue;
            if(visited[nextX][nextY])
                continue;
            visited[nextX][nextY] = true;
            if(i < 2) {
                if (x != beforeX) {
                    dfs(nextX, nextY, x, straight+1, corner);
                }else{
                    dfs(nextX, nextY, x, straight+1, corner+1);
                }
            }else{
                if (x != beforeX) {
                    dfs(nextX, nextY, x, straight+1, corner+1);
                }else{
                    dfs(nextX, nextY, x, straight+1, corner);
                }
            }
            visited[nextX][nextY] = false;
        }
    }
  */
}
