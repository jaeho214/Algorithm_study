package programmers.heap;

import java.util.PriorityQueue;

public class PGMS_더맵게_second {
    public static void main(String[] args) {
        PGMS_더맵게_second pgms_더맵게_second = new PGMS_더맵게_second();
        int[] scoville = {1,2,3,9,10,12};
        int K = 700;
        pgms_더맵게_second.solution(scoville, K);
    }
    boolean res = true;
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int s : scoville)
            pq.offer(s);

        while(true){
            if(check(pq, K))
                break;

            calculate(pq);
            if (!res)
                break;
            answer ++;
        }

        if(!res)
            return -1;
        return answer;
    }

    public void calculate(PriorityQueue<Integer> pq){
        try {
            int first = pq.poll();
            int second = pq.poll();

            int scoville = first + (2 * second);

            pq.offer(scoville);
        }catch (NullPointerException e){
            res = false;
            return;
        }
    }

    public boolean check(PriorityQueue<Integer> pq, int k){
        if(pq.peek() > k)
            return true;

        return false;
    }
}
