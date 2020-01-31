package heap;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class PGMS_이중우선순위큐 {
    public static void main(String[] args) {
        String[] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        PGMS_이중우선순위큐 pgms_이중우선순위큐 = new PGMS_이중우선순위큐();
        int[] res = pgms_이중우선순위큐.solution(operations);
        //System.out.println("[" + res[0] + ", " + res[1] + "]");
    }

    public int[] solution(String[] operations) {
        int[] answer = new int[2];

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        PriorityQueue<Integer> pq_reverse = new PriorityQueue<>((o1, o2) -> o2-o1);

        for(String str : operations){
            String[] s = str.split(" ");
            int num = Integer.parseInt(s[1]);
            if(s[0].equals("I")){
                pq.add(num);
                pq_reverse.add(num);
            }else if(s[0].equals("D")){
                if(pq.isEmpty() && pq_reverse.isEmpty())
                    continue;
                if(s[1].equals("1")) {
                    int max = pq_reverse.poll();
                    pq.remove(max);
                }
                else if(s[1].equals("-1")) {
                    int min = pq.poll();
                    pq_reverse.remove(min);
                }
            }
        }

        if(pq.isEmpty() || pq_reverse.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = pq_reverse.peek();
            answer[1] = pq.peek();
        }

/* Deque 로 풀기
        Deque<Integer> dq = new LinkedList<>();

        for(String str : operations){
            String[] s = str.split(" ");
            int num = Integer.parseInt(s[1]);
            if(s[0].equals("I")){
                if(dq.isEmpty()){
                    dq.add(num);
                    continue;
                }
                if(dq.getFirst() > num)
                    dq.addFirst(num);
                else if(dq.getLast() < num)
                    dq.addLast(num);
            }
            else if(s[0].equals("D")){
                if(dq.isEmpty())
                    continue;
                if(s[1].equals("1"))
                    dq.removeLast();
                else if(s[1].equals("-1"))
                    dq.removeFirst();
            }

        }
        if(dq.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = dq.getFirst();
            answer[1] = dq.getLast();
        }
*/

        return answer;
    }
}
