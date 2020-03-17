package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class Level2_카카오프렌컬러링북 {
    boolean[][] visited;
    int[] moveX = {0,-1,0,1};
    int[] moveY = {1,0,-1,0};

    public class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(picture[i][j] > 0 && !visited[i][j]){
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, bfs(i, j, picture));
                    numberOfArea ++;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private int bfs(int x, int y, int[][] picture){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        int max = 1;
        visited[x][y] = true;
        while(!q.isEmpty()){
            Pair current =  q.poll();
            for(int i=0;i<4;i++){
                int nextX = current.x + moveX[i];
                int nextY = current.y + moveY[i];

                if(nextX >=0 && nextX < picture.length && nextY >= 0 && nextY < picture[0].length){
                    if(!visited[nextX][nextY] && picture[x][y] == picture[nextX][nextY]){
                        visited[nextX][nextY] = true;
                        q.add(new Pair(nextX, nextY));
                        max ++;
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Level2_카카오프렌컬러링북 level2_카카오프렌컬러링북 = new Level2_카카오프렌컬러링북();
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        System.out.println(level2_카카오프렌컬러링북.solution(6, 4, picture));
    }
}
