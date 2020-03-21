package programmers.level2;

import java.util.Stack;

public class Level2_짝지어제거하기 {
    public static void main(String[] args) {
        Level2_짝지어제거하기 level2_짝지어제거하기 = new Level2_짝지어제거하기();
        System.out.println(level2_짝지어제거하기.solution("cdcd"));
    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for(int i=0;i<charArray.length;i++){
            if(stack.isEmpty()){
                stack.push(charArray[i]);
                continue;
            }
            if(charArray[i] == stack.peek())
                stack.pop();
            else
                stack.push(charArray[i]);
        }

        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
