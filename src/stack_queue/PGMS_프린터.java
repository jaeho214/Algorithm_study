package stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class PGMS_프린터 {
    public class Printer{
        int priorities;
        boolean isPrint;
        public Printer(int priorities, boolean isPrint) {
            this.priorities = priorities;
            this.isPrint = isPrint;
        }
    }
    public static void main(String[] args) {
        int[] priorities = {1,7,9,1,1,1};
        PGMS_프린터 pgms_프린터 = new PGMS_프린터();
        System.out.println(pgms_프린터.solution(priorities, 1));
    }

    public int solution(int[] priorities, int location) {
        Queue<Printer> q = new LinkedList<>();
        Queue<Printer> endQ = new LinkedList<>();

        for(int i=0;i<priorities.length;i++){
            if(i == location){
                q.add(new Printer(priorities[i], true));
                continue;
            }
            q.add(new Printer(priorities[i], false));
        }


        while(!q.isEmpty()){
            boolean check = false;
            Printer peek = q.peek();
            for (Printer printer : q) {
                if(peek.priorities < printer.priorities){
                    check = true;
                    break;
                }
            }
            if(check){
                q.poll();
                q.add(peek);
            }else{
                q.poll();
                endQ.add(peek);
            }
        }

        int cnt = 1;
        for(Printer printer : endQ){
            if(printer.isPrint)
                break;
            cnt++;
        }
        return cnt;
    }
}
