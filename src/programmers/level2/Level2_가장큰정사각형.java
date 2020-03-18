package programmers.level2;

/*
 * https://gurumee92.tistory.com/51
 */
public class Level2_가장큰정사각형 {
    public static void main(String[] args) {
        int[][] board = {{1,0},{0,0}};
        Level2_가장큰정사각형 level2_가장큰정사각형 = new Level2_가장큰정사각형();
        System.out.println(level2_가장큰정사각형.solution(board));
    }

    public int solution(int [][]board) {
        int answer = 0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(board[i][j] == 1) {
                    answer = 1;
                    break;
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(i == 0 || j == 0 )
                    continue;
                if(board[i][j] == 0)
                    continue;
                //왼쪽, 왼쪽위, 위쪽이 모두 1이어야만 사각형이 성립이 된다. 셋 중에 하나만 0이더라도 사각형이 성립되지 않는다.
                //세개가 모두 성립하면 1 + 1 인 2가 될 것이고 하나라도 0이면 0 + 1이 되어 1이 될 것이다.
                board[i][j] = Math.min(Math.min(board[i-1][j-1], board[i][j-1]), board[i-1][j]) + 1;
                answer = Math.max(board[i][j], answer);
            }
        }

        return answer*answer;
    }
}
