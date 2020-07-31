package programmers.level3;

public class Level3_가장긴팰린드롬_second {
    public static void main(String[] args) {
        Level3_가장긴팰린드롬_second level3_가장긴팰린드롬_second = new Level3_가장긴팰린드롬_second();
        System.out.println(level3_가장긴팰린드롬_second.solution("abaabaaaaaaa"));
    }

    public int solution(String s) {
        int answer = 0;

        for(int i=0;i<s.length();i++){
            answer = Math.max(answer, Math.max(checkOdd(i, s), checkEven(i,s)));
        }


        return answer;
    }

    private int checkOdd(int i, String s){
        int cnt = 0;
        for(int j=i, k=i; j>=0 && k<s.length(); j--, k++){
            if(s.charAt(j) == s.charAt(k))
                cnt++;
            else
                break;
        }
        return cnt*2-1;
    }

    private int checkEven(int i, String s){
        int cnt = 0;
        for(int j=i, k=i+1;j>=0 && k<s.length(); j--, k++){
            if(s.charAt(j) == s.charAt(k))
                cnt++;
            else
                break;
        }

        return cnt*2;
    }
}
