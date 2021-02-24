package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 리트코드는 전역변수를 반드시 초기화 해주고 값이 바뀌면 안된다
 * dfs가 아닌 while 문으로도 푸는 방식이 있었다.
 */
public class LEET_54_Spiral_Matrix {
    public static void main(String[] args) {
        LEET_54_Spiral_Matrix spiral_matrix = new LEET_54_Spiral_Matrix();
        int[][] matrix = {{1,2,3}, {1,2,3}, {1,2,3}};
        System.out.println(spiral_matrix.spiralOrder(matrix));
    }

    static int[] dy = {1,0,-1,0};
    static int[] dx = {0,1,0,-1};
    static boolean[][] visited;
    static int idx;
    public List<Integer> spiralOrder(int[][] matrix) {
        visited = new boolean[matrix.length][matrix[0].length];
        idx = 0;

        visited[0][0] = true;
        List<Integer> list = new ArrayList<>();
        list.add(matrix[0][0]);
        dfs(0,0, matrix, list,(matrix.length * matrix[0].length)-1);

        return list;
    }

    private void dfs(int x, int y, int[][] matrix, List<Integer> list, int cnt) {

        if(cnt == 0){
            return ;
        }

        int nextX = x+dx[idx];
        int nextY = y+dy[idx];

        if(nextX<0 || nextY<0 || nextX>=matrix.length || nextY>=matrix[0].length || visited[nextX][nextY]) {
            idx++;
            if(idx >= 4) {
                idx = 0;
            }
            nextX = x + dx[idx];
            nextY = y + dy[idx];
        }

        if(nextX>=0 && nextY>=0 && nextX<matrix.length && nextY<matrix[0].length){
            visited[nextX][nextY] = true;
            list.add(matrix[nextX][nextY]);
            dfs(nextX, nextY, matrix, list,  --cnt);
        }
    }
}
