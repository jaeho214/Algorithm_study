package programmers.level2;

import java.util.Stack;

public class Level2_1 {
    public static void main(String[] args) {
        Level2_1 level2_1 = new Level2_1();
        System.out.println(level2_1.solution("4177252841", 4));
    }
    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
