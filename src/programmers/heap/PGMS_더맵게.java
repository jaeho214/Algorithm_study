package programmers.heap;

import java.util.PriorityQueue;
/*
 * 알게된 사실 : JAVA 에선 Heap 이 PriorityQueue 로 구현되어 있다!
 */
public class PGMS_더맵게 {

    public static void main(String[] args) {
        PGMS_더맵게 pgms_더맵게 = new PGMS_더맵게();
        int[] scoville = {1,1,1,1,1};
        System.out.println(pgms_더맵게.solution(scoville, 30));
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : scoville)
            heap.add(i);

        while(!heap.isEmpty()){
            if(heap.size() ==1)
                break;
            if(heap.peek() > K)
                break;
            int first = heap.poll();
            int second = heap.poll();
            int num = first + (second*2);
            heap.offer(num);
            answer ++;
        }

        if(heap.size()==1 && heap.peek() < K)
            return -1;
        return answer;
    }
}
