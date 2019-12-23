package search;

public class PGMS_네트워크 {
    static int[][] computers = {{1,1,0},{1,1,1},{0,1,1}};
    static int n = 3;
    static boolean visited[];
    public static void main(String[] args) {
        visited = new boolean[n];
        int answer = 0;
        for(int i=0;i<computers.length;i++){
            if(!visited[i]) {
                dfs(i);
                answer ++;
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int num) {
        if(visited[num])
            return;

        visited[num] = true;
        for(int i=0;i<computers.length;i++){
            if(computers[num][i] == 1 && !visited[i]){
                dfs(i);
            }
        }
    }
}
