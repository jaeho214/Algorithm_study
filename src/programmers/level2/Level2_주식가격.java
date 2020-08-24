package programmers.level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Level2_주식가격 {
    public static void main(String[] args) {
        Level2_주식가격 level2_주식가격 = new Level2_주식가격();
        int[] price = {1,2,3,2,3,1};
        System.out.println(level2_주식가격.solution(price));
    }

    public int[] solution(int[] prices) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answer = new ArrayList<>();
        for(int i : prices){
            q.add(i);
        }
        while(!q.isEmpty()){
            int num = q.poll();
            int cnt = 0;
            for (Integer i : q) {
                cnt++;
                if(num > i)
                    break;
            }
            answer.add(cnt);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
