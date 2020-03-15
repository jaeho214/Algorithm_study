package programmers.level1;

public class Level1_두정수사이의합 {
    public static void main(String[] args) {
        Level1_두정수사이의합 level1_두정수사이의합 = new Level1_두정수사이의합();
        System.out.println(level1_두정수사이의합.solution(3,6));
    }

    public long solution(int a, int b) {
        long answer = 0;

        if(a==b)
            return a;
        int large=Math.max(a,b);
        int small=Math.min(a,b);

        for(; small<=large; small++, large--){
            if(small==large){
                answer += small;
                break;
            }
            answer += small+large;
        }
        return answer;
    }
}
