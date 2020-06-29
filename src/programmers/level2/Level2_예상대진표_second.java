package programmers.level2;

public class Level2_예상대진표_second {
    public static void main(String[] args) {
        Level2_예상대진표_second level2_예상대진표_second = new Level2_예상대진표_second();
        System.out.println(level2_예상대진표_second.solution(8, 8, 7));
    }

    public int solution(int n, int a, int b) {
        int answer = 1;

        int min = Math.min(a, b)-1;
        int max = Math.max(a, b)-1;

        while (true) {
            if(min/2 == max/2)
                break;
            min /= 2;
            max /= 2;
            answer ++;
        }

        return answer;
    }
}
