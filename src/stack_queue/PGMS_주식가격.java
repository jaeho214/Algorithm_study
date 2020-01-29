package stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PGMS_주식가격 {

    public static void main(String[] args) {
        PGMS_주식가격 pgms_주식가격 = new PGMS_주식가격();
        int[] prices = {1,2,3,2,3};
        int[] res = pgms_주식가격.solution(prices);
        for(int i : res){
            System.out.println(i);
        }
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
