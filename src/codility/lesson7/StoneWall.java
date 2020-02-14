package codility.lesson7;

import java.util.Stack;

public class StoneWall {
    public static void main(String[] args) {
        int[] h = {8,8,5,7,9,8,7,4,8};
        StoneWall stoneWall = new StoneWall();
        System.out.println(stoneWall.solution(h));
    }

    public int solution(int[] H) {
        Stack<Integer> stack = new Stack<>();

        int cnt = 0;
        for(int i = 0; i<H.length; i++){
            while(!stack.isEmpty() && stack.peek() > H[i]){
                stack.pop();
            }
            if(stack.isEmpty() || stack.peek() < H[i]){
                stack.push(H[i]);
                cnt++;
            }
        }
        return cnt;
    }
}
