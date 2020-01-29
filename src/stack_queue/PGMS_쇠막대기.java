package stack_queue;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PGMS_쇠막대기 {
    public class Length{
        int idx;
        char sign;
        public Length(int idx, char sign) {
            this.idx = idx;
            this.sign = sign;
        }
    }

    public class Pair{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public static void main(String[] args) {
        PGMS_쇠막대기 pgms_쇠막대기 = new PGMS_쇠막대기();
        System.out.println(pgms_쇠막대기.solution("()(((()())(())()))(())"));
    }


    public int solution(String arrangement) {
        int answer = 0;

        Stack<Length> stack = new Stack<>();
        List<Double> laserList = new ArrayList();
        List<Pair> pipeList = new ArrayList();
        for(int i=0;i<arrangement.length();i++){
            if(stack.isEmpty()){
                stack.push(new Length(i, arrangement.charAt(i)));
                continue;
            }
            if(stack.peek().sign == '(' && arrangement.charAt((i)) == ')') {
                Length length = stack.pop();
                if(i - length.idx == 1)
                    laserList.add(length.idx+0.5);
                else
                    pipeList.add(new Pair(length.idx, i));
                continue;
            }
            stack.push(new Length(i, arrangement.charAt(i)));
        }

        for(Pair pipe : pipeList){
            int cnt = 1;
            for(Double laser : laserList){
                if(pipe.x <= laser && pipe.y >= laser){
                    cnt++;
                }
            }
            answer += cnt;
        }
        return answer;
    }
}
