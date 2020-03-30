package programmers.level3;

public class Level3_네트워크 {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0}, {1,1,0}, {0,0,1}};
        Level3_네트워크 level3_네트워크 = new Level3_네트워크();
        System.out.println(level3_네트워크.solution(3, computers));
    }
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean visited[] = new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]) {
                dfs(computers, i, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int[][] computers, int idx, boolean[] visited) {

        visited[idx] = true;
        for(int i=0;i<computers[idx].length;i++){
            if(idx == i)
                continue;
            if(computers[idx][i] == 1 && !visited[i]){
                dfs(computers, i, visited);
            }
        }

    }
}
