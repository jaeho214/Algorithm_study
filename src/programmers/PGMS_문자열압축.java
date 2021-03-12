package programmers;

import java.util.Stack;

public class PGMS_문자열압축 {
    public static void main(String[] args) {
        PGMS_문자열압축 pgms_문자열압축 = new PGMS_문자열압축();
        System.out.println(pgms_문자열압축.solution("aabbaccc"));
    }

    public int solution(String s) {

        if(s.length() == 1)
            return 1;

        int answer = Integer.MAX_VALUE;

        int len = s.length();

        //어차피 절반으로밖에 자를 수 없으므로 반만 확인
        for(int i=1;i<=len/2;i++){
            //스택에는 같은 문자열만 저장됨.
            Stack<String> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();

            //i만큼 문자열을 자르면서
            for(int j=0;j<len;j+=i){
                if(stack.isEmpty()){
                    stack.push(s.substring(j, j+i));
                    continue;
                }

                String tmp;
                //마지막에 문자열 범위를 넘어가 버리면 남은 것만
                if(j+i < len){
                    tmp = s.substring(j, j + i);
                //문자열 i만큼 잘라서
                }else{
                    tmp = s.substring(j);
                }
                //stack의 top과 다르다면
                if (!stack.peek().equals(tmp)) {
                    //stack에 저장된 문자열과 개수를 sb에 append
                    sb.append(generateStr(stack));
                    //스택을 비워준다.
                    while (!stack.isEmpty()) stack.pop();
                }
                //stack에 푸시
                stack.push(tmp);
            }

            //스택에 비어있지 않다면
            if(!stack.isEmpty()){
                //남은 것들도 문자열로 변환
                sb.append(generateStr(stack));
                while (!stack.isEmpty()) stack.pop();
            }

            answer = Math.min(answer, sb.length());
        }
        return answer;
    }

    public String generateStr(Stack<String> stack){
        if(stack.size() == 1)
            return stack.pop();
        else
            return stack.size() + stack.pop();
    }

}
