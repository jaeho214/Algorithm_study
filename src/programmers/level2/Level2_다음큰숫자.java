package programmers.level2;

public class Level2_다음큰숫자 {
    public static void main(String[] args) {
        Level2_다음큰숫자 level2_다음큰숫자 = new Level2_다음큰숫자();
        System.out.println(level2_다음큰숫자.solution(15));
    }

    public int solution(int n) {
        int cnt = Integer.bitCount(n);
        int answer = 0;
        while(cnt != answer){
            answer = Integer.bitCount(++n);
        }
        return n;
    }

}
