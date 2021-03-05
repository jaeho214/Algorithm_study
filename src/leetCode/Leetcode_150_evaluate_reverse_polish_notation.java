package leetCode;

import java.util.Stack;

public class Leetcode_150_evaluate_reverse_polish_notation {
    public static void main(String[] args) {
        Leetcode_150_evaluate_reverse_polish_notation evaluate_reverse_polish_notation = new Leetcode_150_evaluate_reverse_polish_notation();
        String[] tokens = {"2" ,"1", "+", "3", "*"};
        System.out.println(evaluate_reverse_polish_notation.evalRPN(tokens));
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for(String token : tokens){
            try{
                stack.add(Integer.parseInt(token));
            }catch (Exception e) {
                int second = stack.pop();
                int first = stack.pop();
                if (token.equals("+")) {
                    stack.add(first+second);
                } else if (token.equals("-")) {
                    stack.add(first-second);
                } else if (token.equals("*")) {
                    stack.add(first*second);
                } else {
                    stack.add(first/second);
                }
            }
        }

        return stack.pop();
    }
}
