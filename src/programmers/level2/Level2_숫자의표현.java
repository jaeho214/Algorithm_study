package programmers.level2;

public class Level2_숫자의표현 {
    public static void main(String[] args) {
        Level2_숫자의표현 level2_숫자의표현 = new Level2_숫자의표현();
        System.out.println(level2_숫자의표현.solution(15));
    }

    public int solution(int n) {
        int answer = 1;

        for(int i=1;i<=n/2;i++){
            int num = i;
            for(int j=i+1;j<=n;j++){
                num += j;
                if(num > n)
                    break;
                if(num == n){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
