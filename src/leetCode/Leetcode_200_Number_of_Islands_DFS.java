package leetCode;

public class Leetcode_200_Number_of_Islands_DFS {

    public static void main(String[] args) {
        Leetcode_200_Number_of_Islands_DFS number_of_islands = new Leetcode_200_Number_of_Islands_DFS();
        char[][] grid = {{'1','1','1','1','0'}, {'1','1','0','1','0'}, {'1','1','0','0','0'},{'0','0','0','0','0'}};
        System.out.println(number_of_islands.numIslands(grid));
    }

    public int numIslands(char[][] grid) {
        int answer = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(int x, int y, char[][] grid) {
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0')
            return;

        grid[x][y] = '0';
        dfs(x+1, y, grid);
        dfs(x-1, y, grid);
        dfs(x, y+1, grid);
        dfs(x, y-1, grid);
    }
}
