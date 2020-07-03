package programmers.stack_queue;

import java.util.Stack;

public class PGMS_탑_second {

    public static void main(String[] args) {
        PGMS_탑_second pgms_탑_second = new PGMS_탑_second();
        int[] heights = {1,5,3,6,7,6,5};
        System.out.println(pgms_탑_second.solution(heights));
    }

    public class Top{
        private int top;
        private int height;

        public Top(int top, int height) {
            this.top = top;
            this.height = height;
        }
    }

    public int[] solution(int[] heights) {
        int[] answer = {};
        answer = new int[heights.length];
        Stack<Top> stack = new Stack<>();
        Stack<Top> fake = new Stack<>();

        for(int i=0;i<heights.length;i++){
            stack.push(new Top(i+1, heights[i]));
        }

        while(!stack.isEmpty()){
            Top t = stack.pop();
            while(!stack.isEmpty()){
                Top pop = stack.pop();
                fake.push(pop);
                if(pop.height > t.height){
                    answer[t.top-1] = pop.top;
                    break;
                }
            }
            while(!fake.isEmpty()){
                stack.push(fake.pop());
            }
        }



        return answer;
    }
}
