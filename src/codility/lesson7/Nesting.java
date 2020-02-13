package codility.lesson7;

import java.util.Stack;

public class Nesting {
    public static void main(String[] args) {
        Nesting nesting = new Nesting();
        System.out.println(nesting.solution("(()(())())"));
    }

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '(')
                stack.push(S.charAt(i));
            else{
                if(stack.isEmpty())
                    return 0;
                else
                    stack.pop();
            }
        }

        if(stack.isEmpty())
            return 1;
        return 0;
    }
}
