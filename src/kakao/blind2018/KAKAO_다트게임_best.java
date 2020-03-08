package kakao.blind2018;

import java.util.Stack;

public class KAKAO_다트게임_best {
    public static void main(String[] args) {
        KAKAO_다트게임_best kakao_다트게임_best = new KAKAO_다트게임_best();
        System.out.println(kakao_다트게임_best.solution("1D2S3T*"));
    }
    public int solution(String dartResult){
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int sum = 0;
        for(int i=0;i<dartResult.length();i++){
            char c = dartResult.charAt(i);
            if(Character.isDigit(c)){
                sum = c - '0';
                //10이면
                if(sum == 1 && i < dartResult.length()-1 && dartResult.charAt(i+1) == '0'){
                    sum = 10;
                    i++;
                }
                stack.push(sum);
            }else{
                int prev = stack.pop();
                if(c == 'D')
                    prev *= prev;
                else if(c=='T')
                    prev = prev * prev * prev;
                else if(c=='*'){
                    if(!stack.isEmpty()){
                        int val = stack.pop() * 2;
                        stack.push(val);
                    }
                    prev *= 2;
                }else if(c=='#'){
                    prev *= -1;
                }
                stack.push(prev);
            }
        }
        while(!stack.isEmpty()){
            answer += stack.pop();
        }
        return answer;
    }
}
