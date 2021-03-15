package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Leetcode_1631_Path_With_Minimum_Effort_BINARY {
    public static void main(String[] args) {
        Leetcode_1631_Path_With_Minimum_Effort_BINARY path_with_minimum_effort = new Leetcode_1631_Path_With_Minimum_Effort_BINARY();
        int[][] heights = {{10,8}, {10,8}, {1,2}, {10,3} ,{1,3} ,{6,3} ,{5,2}};
        System.out.println(path_with_minimum_effort.minimumEffortPath(heights));
    }

    public int minimumEffortPath(int[][] heights) {
        //최대 1000000까지 답이 될 수 있으므로 그 범위를 이분탐색해서 최소값을 찾는다.
        int left = 0, right = 1000001;

        while(left < right){
            int mid = (left + right) / 2;
            if(isPossible(heights, mid))
                right = mid;
            else
                left = mid+1;
        }
        return left;
    }

    private boolean isPossible(int[][] heights, int limit) {
        int rows = heights.length;
        int cols = heights[0].length;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        Queue<int[]> q = new LinkedList();
        boolean[][] visited = new boolean[rows][cols];
        visited[0][0] = true;
        q.add(new int[]{0, 0});

        while(q.size() > 0) {
            int x = q.peek()[0];
            int y = q.peek()[1];
            q.poll();
            if(x == rows - 1 && y == cols - 1)
                return true;
            for(int i=0;i<4;i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny]) {
                    if(Math.abs(heights[x][y] - heights[nx][ny]) <= limit) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return false;
    }
}
