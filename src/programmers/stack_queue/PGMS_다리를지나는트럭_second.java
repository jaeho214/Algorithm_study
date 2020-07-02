package programmers.stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_다리를지나는트럭_second {
    public static void main(String[] args) {
        PGMS_다리를지나는트럭_second pgms_다리를지나는트럭_second = new PGMS_다리를지나는트럭_second();
        int truck_weights[] = {10,10,10,10,10,10,10,10,10,10};
        System.out.println(pgms_다리를지나는트럭_second.solution(100, 100, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> bridge = new LinkedList<>();
        for(int i=0;i<bridge_length;i++)
            bridge.offer(0);
        Queue<Integer> q = new LinkedList<>();

        for(int truck : truck_weights)
            q.add(truck);

        while(true){
            bridge.poll();
            answer++;
            if(!q.isEmpty() && isFull(bridge, weight, q.peek())){
                bridge.offer(0);
                continue;
            }

            if(q.isEmpty() && !check(bridge)){
                bridge.offer(0);
                continue;
            }

            if(q.isEmpty() && check(bridge))
                break;

            int poll = q.poll();
            bridge.offer(poll);
        }

        return answer;
    }

    private boolean isFull(Queue<Integer> q, int weight, int num){
        Iterator<Integer> iterator = q.iterator();
        while(iterator.hasNext()){
            num += iterator.next();
            if(num > weight)
                return true;
        }

        return false;
    }

    private boolean check(Queue<Integer> q){
        Iterator<Integer> iterator = q.iterator();
        int sum = 0;
        while(iterator.hasNext()){
            sum += iterator.next();
            if(sum > 0)
                return false;
        }
        return true;
    }
}
