package kakao.blind2019;

import java.util.LinkedList;
import java.util.Queue;

public class KAKAO_블록게임 {
    public static void main(String[] args) {
        KAKAO_블록게임 kakao_블록게임 = new KAKAO_블록게임();
        int[][] board = {
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,6,0,0},
                {0,0,0,0,5,0,6,6,6,0},
                {0,0,0,4,5,5,5,0,0,0},
                {0,0,3,4,4,4,8,0,0,0},
                {1,2,3,3,3,8,8,0,0,0},
                {1,2,2,2,0,7,8,0,0,0},
                {1,1,0,0,7,7,7,0,0,0}
        };

        System.out.println(kakao_블록게임.solution(board));
        }
    public class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {
        int answer = 0;
        int len = board.length;
        boolean[] visited = new boolean[201];
        Queue<Pair> impossible = new LinkedList<>();
        for(int i=0;i<len;i++){
            for (int j=0;j<len;j++){
                if(board[i][j] == 0 || visited[board[i][j]])
                    continue;
                visited[board[i][j]] = true;
                impossible.add(new Pair(i, j));
            }
        }
        int cnt = 100001;
        while(cnt > 0){
            Pair pair = impossible.poll();
            int num = checkArray(board, pair.x, pair.y, len);
            //2. 제거하지 못할 때마다 cnt -- 해줌
            //cnt가 0이 된다면 마지막으로 제거될 수 있는 도형이 제거된 후 남은 도형들은 전부 제거할 수 없다는 의미이므로 그때 반복문 종료
            if(num==0) {
                cnt--;
                impossible.add(pair);
            //1. 제거를 할 수 있는 순간 cnt를 현재 큐의 사이즈로 맞춰주고
            }else {
                cnt = impossible.size();
                answer += num;
            }
        }
        return answer;
    }

    //도형을 제거할 수 있는 경우의 수는 5가지이다.
    //그 5가지의 경우일 때마다 제거해준다.
    public int checkArray(int[][] board, int i, int j, int len){
        boolean check = true;

        if(i+1<len && j+2<len && board[i][j] == board[i+1][j+2]) {
            for (int k = 0; k < i + 1; k++) {
                if (board[k][j + 1] != 0 || board[k][j + 2] != 0) {
                    check=false;
                    return 0;
                }
            }
            if(check) {
                board[i][j] = 0;
                board[i+1][j] = 0;
                board[i + 1][j + 1] = 0;
                board[i + 1][j + 2] = 0;
                return 1;
            }
        }
        else if(i+2<len && j-1>=0 && board[i][j] == board[i+2][j-1]){
            for(int k=0;k<i+2;k++){
                if(board[k][j-1] != 0){
                    check=false;
                    return 0;
                }
            }
            if(check){
                board[i][j] = 0;
                board[i+1][j] = 0;
                board[i+2][j] = 0;
                board[i+2][j-1] = 0;
                return 1;
            }
        }
        else if(i+2<len && j+1<len && board[i][j] == board[i+2][j+1] ){
            for(int k=0;k<i+2;k++){
                if(board[k][j+1] != 0){
                    check=false;
                    return 0;
                }
            }
            if(check){
                board[i][j] = 0;
                board[i+1][j] = 0;
                board[i+2][j] = 0;
                board[i+2][j+1] = 0;
                return 1;
            }
        }
        else if(i+1<len && j-2>=0 && board[i][j] == board[i+1][j-2] ){
            for(int k=0;k<i+1;k++){
                if(board[k][j-2] != 0 || board[k][j-1] != 0){
                    check=false;
                    return 0;
                }
            }
            if(check){
                board[i][j] = 0;
                board[i+1][j] = 0;
                board[i+1][j-1] = 0;
                board[i+1][j-2] = 0;
                return 1;
            }
        }
        else if(i+1<len && j+1<len && j-1>=0 && board[i][j] == board[i+1][j+1] && board[i][j] == board[i+1][j-1] ){
            for(int k=0;k<i+1;k++){
                if(board[k][j-1] != 0 || board[k][j+1] != 0){
                    check=false;
                    return 0;
                }
            }
            if(check){
                board[i][j] = 0;
                board[i+1][j-1] = 0;
                board[i+1][j] = 0;
                board[i+1][j+1] = 0;
                return 1;
            }
        }
        return 0;
    }
}
