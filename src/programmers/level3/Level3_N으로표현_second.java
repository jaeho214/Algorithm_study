package programmers.level3;

public class Level3_N으로표현_second {
    public static void main(String[] args) {
        Level3_N으로표현_second level3_n으로표현_second = new Level3_N으로표현_second();
        System.out.println(level3_n으로표현_second.solution(5, 12));
    }
    private int min = Integer.MAX_VALUE;
    private int N = 0;
    private int number = 0;
    public int solution(int N, int number) {
        this.number = number;
        this.N = N;

        dfs(0,0);

        return min > 8 ? -1:min;
    }

    private void dfs(int num, int cnt){
        if(cnt > 8)
            return;

        if(num == number && cnt <= 8) {
            min = Math.min(cnt, min);
            return;
        }

        int tmp = 0;
        for(int i=1;i<=8;i++){
            tmp = tmp*10 + this.N;
            dfs(num+tmp, cnt+i);
            dfs( num-tmp, cnt+i);
            dfs( num*tmp, cnt+i);
            dfs( num/tmp, cnt+i);
        }
    }
}
