package programmers.level3;
/*
 * https://jayrightthere.tistory.com/entry/DFSJAVA-N%EC%9C%BC%EB%A1%9C-%ED%91%9C%ED%98%84
 */
public class Level3_N으로표현 {
    public static void main(String[] args) {
        Level3_N으로표현 level3_n으로표현 = new Level3_N으로표현();
        System.out.println(level3_n으로표현.solution(5, 12));
    }
    int answer = -1;
    public int solution(int N, int number){
        dfs(N, 0, 0, number);
        return answer;
    }

    private void dfs(int n, int position, int current, int number) {
        if(position > 8)
            return ;

        //목표 숫자에 도달하면 answer 갱신
        if(current == number) {
            if (position < answer || answer == -1)
                answer = position;
            return;
        }

        int tmp = 0;
        for(int i=1;i<=8;i++){
            //tmp에는 사칙연산이 아닌 숫자가 연속되는 경우까지 고려
            tmp = tmp*10 + n;
            dfs(n, position+i, current+tmp, number);
            dfs(n, position+i, current-tmp, number);
            dfs(n, position+i, current*tmp, number);
            dfs(n, position+i, current/tmp, number);
        }
    }
}
