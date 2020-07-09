package programmers.greedy;

import java.util.Stack;

public class PGMS_큰수만들기_second {
    public static void main(String[] args) {
        PGMS_큰수만들기_second pgms_큰수만들기_second = new PGMS_큰수만들기_second();
        System.out.println(pgms_큰수만들기_second.solution("777777", 2));
    }

    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<number.length();i++){
            int num = number.charAt(i) - '0';
            if(stack.isEmpty()){
                stack.push(num);
                continue;
            }

            if (stack.peek() < num && k > 0) {
                while (stack.peek() < num) {
                    k--;
                    stack.pop();
                    if (stack.isEmpty() || k == 0)
                        break;
                }
            }
            stack.push(num);


        }

        while(!stack.isEmpty())
            answer.append(stack.pop());

        for(int i=answer.length()-1;i>=0;i--){
            sb.append(answer.charAt(i));
        }

        if(sb.length() > number.length()-k)
            sb.delete(number.length()-k, number.length());
        
        return sb.toString();
    }
}
