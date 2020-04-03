package kakao.internship2019;

import java.util.Stack;

public class KAKAO_크레인인형뽑기게임 {
    public static void main(String[] args) {
        KAKAO_크레인인형뽑기게임 kakao_크레인인형뽑기게임 = new KAKAO_크레인인형뽑기게임();
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};
        System.out.println(kakao_크레인인형뽑기게임.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> result = new Stack<>();
        for(int move : moves){
            for(int i=0;i<board.length;i++){
                if(board[i][move-1] > 0){
                    if(result.isEmpty()){
                        result.push(board[i][move-1]);
                    }else{
                        if(result.peek() == board[i][move-1]){
                            result.pop();
                            answer += 2;
                        }else{
                            result.push(board[i][move-1]);
                        }
                    }
                    board[i][move-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
