package programmers.level3;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Level3_야근지수_second {
    public static void main(String[] args) {
        Level3_야근지수_second level3_야근지수_second = new Level3_야근지수_second();
        int[] works = {1,1};
        System.out.println(level3_야근지수_second.solution(3, works));
    }

    public long solution(int n, int[] works) {
        long answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int work : works)
            pq.offer(work);

        while(n>0){
            n --;

            int max = pq.poll();
            if(max == 0)
                break;
            pq.offer(--max);
        }

        Iterator<Integer> iterator = pq.iterator();
        while(iterator.hasNext()){
            answer += Math.pow(iterator.next(), 2);
        }

        return answer;
    }
}
