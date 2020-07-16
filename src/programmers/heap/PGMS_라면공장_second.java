package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class PGMS_라면공장_second {

    public static void main(String[] args) {
        int[] dates = {4,10,15};
        int[] supplies = {20, 5, 10};
        PGMS_라면공장_second pgms_라면공장_second = new PGMS_라면공장_second();
        System.out.println(pgms_라면공장_second.solution(4, dates, supplies, 30));
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        int idx = 0;
        for(int i=0;i<k;i++){
            if(idx < dates.length && dates[idx] == i){
                pq.offer(supplies[idx]);
                idx++;
            }

            if(stock == 0){
                int poll = pq.poll();
                stock += poll;
                answer++;
            }
            stock--;
        }



        return answer;
    }

}
