package bfs_dfs;

public class PGMS_타켓넘버 {
    static int[] numbers = {1,1,1,1,1};
    static int target = 3;
    static int answer = 0;
    public static void main(String[] args) {
        int plus = numbers[0];
        int minus = -numbers[0];
        dfs(plus,1);
        dfs(minus, 1);
        System.out.println(answer);
    }

    private static void dfs(int num, int cnt) {
        if(numbers.length == cnt) {
            if(num == target) {
                answer++;
            }
            return;
        }
        dfs(num + numbers[cnt], cnt+1);
        dfs(num - numbers[cnt], cnt+1);

    }
}
