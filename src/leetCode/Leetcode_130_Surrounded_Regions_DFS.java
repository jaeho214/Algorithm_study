package leetCode;

public class Leetcode_130_Surrounded_Regions_DFS {
    public static void main(String[] args) {
        Leetcode_130_Surrounded_Regions_DFS surroundedRegions = new Leetcode_130_Surrounded_Regions_DFS();
        char[][] board = {{'X','O','X'},{'O','X','O'},{'X','O','X'}};
        surroundedRegions.solve(board);
    }

    char[][] board;
    int rows, cols;
    public void solve(char[][] board){
        if(board == null || board.length == 0)
            return;

        this.rows = board.length;
        this.cols = board[0].length;
        this.board = board;

        //우선 바깥 O와 이어지는 O들을 다 B로 바꿔놓고
        flip('O', 'B');

        //내부 O들은 다 X로 바꿈
        for(int i=1;i<rows-1;i++){
            for(int j=1;j<cols-1;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }

        //B로 바꿔놨던 것들을 O로 바꿔줌
        flip('B', 'O');
    }

    private void flip(char ch, char target) {
        for(int i=0;i<rows;i++){
            if(board[i][0] == ch)
                dfs(i, 0, target);

            if(board[i][cols-1] == ch)
                dfs(i, cols-1, target);
        }

        for(int i=0;i<cols;i++){
            if(board[0][i] == ch)
                dfs(0, i, target);

            if(board[rows-1][i] == ch)
                dfs(rows-1, i, target);
        }
    }

    private void dfs(int row, int col, char target) {
        if(row < 0 || col < 0 || row >= rows || col >= cols || board[row][col] == target || board[row][col] == 'X')
            return;

        board[row][col] = target;

        dfs(row, col-1, target);
        dfs(row, col+1, target);
        dfs(row-1, col, target);
        dfs(row+1, col, target);
    }
}
