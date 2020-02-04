package programmers.greedy;

public class PGMS_큰수만들기 {
    public static String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int delete_count = 0;
        int index = 1;

        while(delete_count != k){
            //앞에서 부터 작은 수들을 잘라나감
            if(index>=1 && sb.charAt(index) > sb.charAt(index-1)){
                sb.deleteCharAt(index-1);
                //위에서 바로 전꺼를 지워줬으므로 인덱스가 -1씩 밀려남 그래서 index --
                index--;
                delete_count ++;
            }else{
                //다 잘랐는데도 부족하다? 그럼 뒤에서 부터 자른다
                if(index == sb.length()-1 && sb.charAt(index) <= sb.charAt(index-1)){
                    sb.deleteCharAt(index);
                    index--;
                    delete_count ++;
                }else{
                    index++;
                }
            }
        }

        return sb.toString();
    }

    /* 반성하게 만드는 코드,,,, 자료구조 진짜 못쓴다 나
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
     */

    public static void main(String[] args) {
        System.out.println(solution("1231234", 3));
    }
}
