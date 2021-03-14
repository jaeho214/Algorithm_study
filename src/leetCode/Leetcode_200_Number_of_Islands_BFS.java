package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_200_Number_of_Islands_BFS {
    public static void main(String[] args) {
        Leetcode_200_Number_of_Islands_BFS number_of_islands = new Leetcode_200_Number_of_Islands_BFS();
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(number_of_islands.numIslands(grid));
    }

    public static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    int dx[] = {-1,1,0,0};
    int dy[] = {0,0,-1,1};
    boolean[][] visited;
    public int numIslands(char[][] grid) {
        this.visited = new boolean[grid.length][grid[0].length];

        int answer = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j] || grid[i][j] == '0')
                    continue;
                bfs(i, j, grid);
                answer ++;
            }
        }

        return answer;
    }

    private void bfs(int x, int y, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(x, y));


        while(!q.isEmpty()){
            Pair current = q.poll();
            visited[current.x][current.y] = true;
            for(int i=0;i<4;i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length)
                    continue;
                if(visited[nextX][nextY] || grid[nextX][nextY] == '0')
                    continue;

                visited[nextX][nextY] = true;
                q.offer(new Pair(nextX, nextY));
            }
        }
    }
}
