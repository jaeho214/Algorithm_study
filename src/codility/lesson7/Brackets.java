package codility.lesson7;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Brackets {
    public static void main(String[] args) {
        Brackets brackets = new Brackets();
        System.out.println(brackets.solution("({})({}"));
    }

    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        List<Character> list1 = Arrays.asList('(', ')');
        List<Character> list2 = Arrays.asList('{', '}');
        List<Character> list3 = Arrays.asList('[', ']');

        for(int i=0;i<S.length();i++){
            if(S.charAt(i) == '[' || S.charAt(i) == '(' || S.charAt(i) == '{')
                stack.push(S.charAt(i));
            else{
                if(stack.isEmpty())
                    return 0;
                else if(list1.contains(stack.peek()) && list1.contains(S.charAt(i))){
                    stack.pop();
                }
                else if(list2.contains(stack.peek()) && list2.contains(S.charAt(i))){
                    stack.pop();
                }
                else if(list3.contains(stack.peek()) && list3.contains(S.charAt(i))){
                    stack.pop();
                }else
                    return 0;
            }
        }

        if(stack.isEmpty())
            return 1;
        return 0;
    }

}
