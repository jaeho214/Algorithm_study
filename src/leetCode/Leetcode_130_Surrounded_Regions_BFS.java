package leetCode;

import java.util.*;

public class Leetcode_130_Surrounded_Regions_BFS {
    public static void main(String[] args) {
        Leetcode_130_Surrounded_Regions_BFS surroundedRegions = new Leetcode_130_Surrounded_Regions_BFS();
        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        surroundedRegions.solve(board);
    }
    private static class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    Set<Pair> set = new HashSet<>();
    boolean[][] visited;
    public void solve(char[][] board) {


        visited = new boolean[board.length][board[0].length];

        //바깥쪽만 확인하면서 O로 이어진 것들 set에다가 저장
        for(int i=0;i<board.length;i++){
            if(board[i][0] == 'O')
                reverse(i, 0, board);

            if(board[i][board[i].length-1] == 'O')
                reverse(i, board[i].length - 1, board);

        }

        for(int i=0;i<board[0].length; i++){
            if(board[0][i] == 'O')
                reverse(0, i, board);

            if(board[board.length-1][i] == 'O')
                reverse(board.length - 1, i, board);
        }


        //다 X로 초기화 후
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j] = 'X';
            }
        }

        //set에 저장된 좌표는 O로 전환
        for(Pair pair : set){
            board[pair.x][pair.y] = 'O';
        }

    }

    public void reverse(int x, int y, char[][] board){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y));
        set.add(new Pair(x, y));
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        while (!q.isEmpty()){
            Pair current = q.poll();
            visited[x][y] = true;
            for(int i=0;i<4;i++){
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if(nextX < 0 || nextY < 0 || nextX >= visited.length || nextY >= visited[0].length)
                    continue;
                if(board[nextX][nextY] == 'X')
                    continue;
                if(visited[nextX][nextY])
                    continue;

                set.add(new Pair(nextX, nextY));
                q.add(new Pair(nextX, nextY));
                visited[nextX][nextY] = true;
            }
        }
    }
}
