package programmers.bfs_dfs;

public class PGMS_네트워크_second {
    public static void main(String[] args) {
        PGMS_네트워크_second pgms_네트워크_second = new PGMS_네트워크_second();
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        System.out.println(pgms_네트워크_second.solution(3, computers));
    }
    private boolean[] visited;
    private int n;
    private int[][] computers;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        this.n = n;
        visited = new boolean[n];
        this.computers = computers.clone();


        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int num){

        visited[num] = true;
        
        for(int i=0;i<n;i++){
            if(visited[i] || computers[num][i] == 0)
                continue;
            dfs(i);
        }
    }
}
