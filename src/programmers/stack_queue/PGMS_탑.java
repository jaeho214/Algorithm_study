package programmers.stack_queue;

import java.util.Stack;

public class PGMS_탑 {
    public static void main(String[] args) {
        PGMS_탑 pgms_탑 = new PGMS_탑();
        int[] heights = {1,5,3,6,7,6,5};
        int[] res = pgms_탑.solution(heights);
        for (int i : res) {
            System.out.println(i + " ");
        }
    }

    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i : heights)
            stack.add(i);

        int idx = heights.length-1;

        while(!stack.isEmpty()){
            int num = stack.pop();
            for(int i=idx;i>=0;i--){
                if(num < heights[i]){
                    answer[idx] = i+1;
                    break;
                }
            }
            idx--;
        }


        return answer;
    }
}
