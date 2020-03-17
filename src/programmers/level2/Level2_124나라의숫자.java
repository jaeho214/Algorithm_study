package programmers.level2;
/*
 * https://cnwlcjf.tistory.com/64
 */
public class Level2_124나라의숫자 {
    public static void main(String[] args) {
        Level2_124나라의숫자 level2_124나라의숫자 = new Level2_124나라의숫자();
        System.out.println(level2_124나라의숫자.solution(21));
    }

    public String solution(int n) {
        String answer = "";
        int num = 0;

        while(n>0){
            num = n % 3;
            n /= 3;

            if(num == 0){
                n --;
                num = 4;
            }
            answer = num + answer;
        }

        return answer;
    }
}
