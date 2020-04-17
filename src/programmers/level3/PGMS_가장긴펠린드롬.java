package programmers.level3;

public class PGMS_가장긴펠린드롬 {
    public static void main(String[] args) {
        PGMS_가장긴펠린드롬 pgms_가장긴펠린드롬 = new PGMS_가장긴펠린드롬();
        System.out.println(pgms_가장긴펠린드롬.solution("aa"));
    }

    public int solution(String s){
        int answer = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            int odd = checkOdd(s, i);
            int even = checkEven(s, i);

            //홀수개를 카운트한 경우
            if(answer < odd){
                answer = odd;
                flag = true;
            }

            //짝수개를 카운트한 경우
            //aa의 경우 짝수개인데 odd와 결과가 같음을 대비해서 <= 로 조건을 걸어줌
            if(answer <= even){
                answer = even;
                flag = false;
            }
        }


        if(flag)
            return (answer*2)-1;
        return answer*2;
    }

    //한개를 기준으로 양쪽으로 퍼지면서 카운트 ex) aba
    private int checkOdd(String s, int idx){
        int cnt = 0;
        for(int i=idx, j=idx; i>=0 && j<s.length(); i--, j++){
            if(s.charAt(i) != s.charAt(j))
                break;
            cnt++;
        }
        return cnt;
    }

    //두개를 기준으로 양쪽으로 퍼지면서 카운트 ex) abba
    private int checkEven(String s, int idx){
        int cnt = 0;
        for(int i=idx, j=idx+1; i>=0 && j<s.length(); i--, j++){
            if(s.charAt(i) != s.charAt(j))
                break;
            cnt++;
        }
        return cnt;
    }
}
