package leetCode;

import java.util.*;

public class Leetcode_279_Perfect_Squares_QUEUE {
    public static void main(String[] args) {
        Leetcode_279_Perfect_Squares_QUEUE perfect_squares = new Leetcode_279_Perfect_Squares_QUEUE();
        System.out.println(perfect_squares.numSquares(6603));
    }

    public int numSquares(int n) {
        if(n <= 0) return 0;
        if(n < 4) return n;

        boolean[] visited = new boolean[n+1];
        int level = 0;

        //n에서 시작해서 점점 수를 낮춰가면서 하는 문제인듯
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);

        while(!q.isEmpty()){
            //큐의 사이즈를 구하고
            int size = q.size();
            //정답 변수를 ++
            level++;
            //큐를 돌면서
            for(int i=0;i<size;i++){
                int value = q.poll();
                //제곱값이 value보다 같거나 작을때까지만 돌고
                for(int j=1;j*j<=value;j++){
                    //value에서 제곱값을 뺀 값을 next에 저장
                    int next = value - j*j;
                    //0에 도달하면 바로 level을 리턴하고
                    if(next == 0) return level;
                    //그렇지 않으면
                    else{
                        //이미 방문한 곳으면 continue;
                        if(visited[next]) continue;
                        //방문 안했으면 방문하고
                        visited[next] = true;
                        //next를 큐에 넣어서 다시 돌 수 있게끔 한다.
                        q.offer(next);
                    }
                }
            }
        }
        //0에 도달하지 못하고 여기까지 왔다면 level이 최소값임
        return level;
    }
}
