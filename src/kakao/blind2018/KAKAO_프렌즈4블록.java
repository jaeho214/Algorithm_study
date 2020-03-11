package kakao.blind2018;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO_프렌즈4블록 {
    public char boardArray[][];
    public Queue<Pair> blockList = new LinkedList<>();
    public static void main(String[] args) {
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        KAKAO_프렌즈4블록 kakao_프렌즈4블록 = new KAKAO_프렌즈4블록();
        System.out.println(kakao_프렌즈4블록.solution(6,6, board));
    }
    public class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int m, int n, String[] board) {
        if(m<2 || n<2)
            return 0;
        int answer = 0;
        boardArray = new char[m][n];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length();j++){
                boardArray[i][j] = board[i].charAt(j);
            }
        }
        while(true) {
            if (!getBlock())
                break;

            //블럭리스트에서 지우고 카운트
            while (!blockList.isEmpty()) {
                Pair remove = blockList.poll();
                if (boardArray[remove.x][remove.y] == ' ')
                    continue;
                boardArray[remove.x][remove.y] = ' ';
                answer++;
            }
            //블럭들 내리기
            blockDown();

        }

        return answer;
    }

    private boolean getBlock(){
        for(int i=0;i<boardArray.length;i++) {
            for (int j = 0; j < boardArray[i].length; j++) {
                if(boardArray[i][j] == ' ')
                    continue;
                if(i+1 >= boardArray.length || j+1 >= boardArray[i].length)
                    continue;
                if (boardArray[i][j] == boardArray[i + 1][j]
                        && boardArray[i][j] == boardArray[i][j + 1]
                        && boardArray[i][j] == boardArray[i + 1][j + 1]) {
                    blockList.add(new Pair(i, j));
                    blockList.add(new Pair(i + 1, j));
                    blockList.add(new Pair(i, j + 1));
                    blockList.add(new Pair(i + 1, j + 1));
                }
            }
        }
        if(blockList.isEmpty())
            return false;
        return true;
    }

    //블럭을 내리는 부분에서 문제 발생
    private void blockDown(){
        for(int j=0;j<boardArray[0].length;j++){
            Queue<Pair> blankQ = new LinkedList<>();
            for(int i=boardArray.length-1;i>=0;i--){
                if(boardArray[i][j] == ' ')
                    blankQ.add(new Pair(i,j));
                if(boardArray[i][j] != ' ' && !blankQ.isEmpty()){
                    Pair poll = blankQ.poll();
                    boardArray[poll.x][poll.y] = boardArray[i][j];
                    boardArray[i][j] = ' ';
                    //해당 블록을 내리면 그 자리는 또 공백이 되기 때문에 위에껄로 채워줘야한다
                    //따라서 공백큐에 해당 블록의 위치를 넣어준다.
                    blankQ.add(new Pair(i,j));
                }
            }
        }
    }

}
