package programmers.stack_queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PGMS_기능개발_second {
    public static void main(String[] args) {
        PGMS_기능개발_second pgms_기능개발_second = new PGMS_기능개발_second();
        int[] progresses = {99,99,99,99,99};
        int[] speeds = {3,3,3,3,3};
        System.out.println(pgms_기능개발_second.solution(progresses, speeds));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};

        Queue<Integer> q = new LinkedList<>();
        Queue<Integer> answerQ = new LinkedList<>();
        for(int i=0;i<progresses.length;i++){
            int num = 100 - progresses[i];
            if(num%speeds[i] == 0)
                q.add(num/speeds[i]);
            else
                q.add(num/speeds[i] + 1);

        }
        while(!q.isEmpty()){
            int cri = q.poll();
            int ans = 1;
            while(!q.isEmpty()){
                if(cri >= q.peek()){
                    q.poll();
                    ans++;
                    continue;
                }
                break;
            }
            answerQ.offer(ans);
        }

        int idx = 0;
        answer = new int[answerQ.size()];
        Iterator<Integer> iterator = answerQ.iterator();
        while(iterator.hasNext()){
            answer[idx++] = iterator.next();
        }

        return answer;
    }
}
