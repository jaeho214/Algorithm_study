package programmers.level2;

public class Level2_예상대진표 {
    public static void main(String[] args) {
        Level2_예상대진표 level2_예상대진표 = new Level2_예상대진표();
        System.out.println(level2_예상대진표.solution(8,1,7));
    }
    public int solution(int n, int a, int b) {
        int answer = 0;
        int A = Math.min(a,b);
        int B = Math.max(a,b);

        while(A>0 && B>0){
            answer++;
            A = (A+1)/2;
            B = (B+1)/2;
            if(A == B)
                return answer;

        }
        return answer;
    }
}
