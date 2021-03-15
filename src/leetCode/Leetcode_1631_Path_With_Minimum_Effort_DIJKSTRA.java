package leetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Leetcode_1631_Path_With_Minimum_Effort_DIJKSTRA {
    public static void main(String[] args) {
        Leetcode_1631_Path_With_Minimum_Effort_DIJKSTRA path_with_minimum_effort = new Leetcode_1631_Path_With_Minimum_Effort_DIJKSTRA();
        int[][] heights = {{10,8}, {10,8}, {1,2}, {10,3} ,{1,3} ,{6,3} ,{5,2}};
        System.out.println(path_with_minimum_effort.minimumEffortPath(heights));
    }
    public int minimumEffortPath(int[][] heights) {

        int rows = heights.length;
        int cols = heights[0].length;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        boolean[][] visited = new boolean[rows][cols];
        q.add(new int[]{0,0,0});

        int[][] cost = new int[rows][cols];
        for(int i=0;i<rows;i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }

        cost[0][0] = 0;

        while(!q.isEmpty()){
            int[] current = q.poll();
            //(x,y)좌표와 그 좌표까지의 최소값 z
            int x = current[0];
            int y = current[1];
            int z = current[2];
            visited[x][y] = true;

            for(int i=0;i<4;i++){
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                if(nextX < 0 || nextY < 0 || nextX>=rows || nextY>=cols)
                    continue;
                if(visited[nextX][nextY])
                    continue;

                //다음 좌표와의 차이의 최대값을 구하고
                int maxCost = Math.max(Math.abs(heights[x][y] - heights[nextX][nextY]), z);

                //cost 값 갱신
                if(maxCost < cost[nextX][nextY]){
                    cost[nextX][nextY] = maxCost;
                    q.add(new int[]{nextX, nextY, cost[nextX][nextY]});
                }
            }
        }

        return cost[rows-1][cols-1];
    }

}
