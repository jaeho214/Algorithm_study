package programmers.level2;

import java.util.Stack;

public class Level2_올바른괄호 {
    public static void main(String[] args) {
        Level2_올바른괄호 level2_올바른괄호 = new Level2_올바른괄호();
        System.out.println(level2_올바른괄호.solution(")()("));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            try {
                if (c == '(')
                    stack.push('(');
                else
                    stack.pop();
            }catch (Exception e){
                return false;
            }
        }
        if(!stack.isEmpty())
            return false;

        return true;
    }
}
