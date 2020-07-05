package programmers.bfs_dfs;

public class PGMS_타겟넘버_second {
    public static void main(String[] args) {
        PGMS_타겟넘버_second pgms_타겟넘버_second = new PGMS_타겟넘버_second();
        int[] numbers = {1,1,1,1,1};
        pgms_타겟넘버_second.solution(numbers, 3);
    }
    private int target;
    private int answer = 0;
    private int[] numbers;
    public int solution(int[] numbers, int target) {
        this.target = target;
        this.numbers = new int[numbers.length];

        for(int i=0;i<numbers.length;i++)
            this.numbers[i] = numbers[i];

        dfs(this.numbers[0], 1);
        dfs(this.numbers[0] * -1, 1);


        return answer;
    }

    private void dfs(int sum, int cnt){
        if(cnt ==  numbers.length){
            if(sum == target)
                answer++;
            return;
        }

        dfs(sum + numbers[cnt], cnt+1);
        dfs(sum - numbers[cnt], cnt+1);

    }
}
