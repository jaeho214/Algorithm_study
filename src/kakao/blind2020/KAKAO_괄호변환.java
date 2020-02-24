package kakao.blind2020;

import java.util.Stack;

public class KAKAO_괄호변환 {

    public static void main(String[] args) {
        KAKAO_괄호변환 kakao_괄호변환 = new KAKAO_괄호변환();
        System.out.println(kakao_괄호변환.solution(")()()("));
    }

    public String solution(String p) {
        String answer = "";

        answer = recursion(p);

        return answer;
    }

    private String recursion(String p){
        if(p.equals(""))
            return "";

        if(isRight(p))
            return p;

        int num = getBalance(p);
        String u = p.substring(0, num+1);
        String v = p.substring(num+1);
        String str = "";
        if(!isRight(u)) {
            u = u.substring(1, u.length() - 1);
            for (int i = 0; i < u.length(); i++) {
                if (u.charAt(i) == ')')
                    str += "(";
                else
                    str += ")";
            }
            //아 v인데 u로 계속 잘못보고 풀었다,, 고치니까 한번에 맞았다.
            return "(" + recursion(v) + ")"+ str;
        }
        else
            return u + recursion(v);

    }

    private boolean isRight(String p){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<p.length();i++){
            if(stack.isEmpty() && p.charAt(i) == ')'){
                return false;
            }
            if(p.charAt(i) == '(')
                stack.push(p.charAt(i));
            else if(p.charAt(i) == ')')
                stack.pop();
        }
        return true;
    }

    private int getBalance(String p){
        int cnt1 = 0, cnt2 = 0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i) == '(')
                cnt1++;
            else if(p.charAt(i) == ')')
                cnt2++;
            if(cnt1 == cnt2)
                return i;
        }
        return 0;
    }
}
