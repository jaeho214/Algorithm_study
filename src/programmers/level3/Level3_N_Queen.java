package programmers.level3;

public class Level3_N_Queen {
    public static void main(String[] args) {
        Level3_N_Queen level3_n_queen = new Level3_N_Queen();
        System.out.println(level3_n_queen.solution(5));
    }
    int answer = 0;
    int col[];

    public int solution(int n) {
        for(int i=1;i<=n;i++){
            col = new int[n+1];
            col[1] = i;
            dfs(n, 1);
        }

        return answer;
    }

    public boolean isPossible(int n) {
        int idx = 1;

        while(idx<n){
            if(col[n] == col[idx] || Math.abs(col[n] - col[idx]) == n-idx)
                return false;
            idx ++;
        }

        return true;
    }

    public void dfs(int n, int row){
        if(row == n){
            ++answer;
        }else{
            for(int i=1;i<=n;i++){
                //col[row+1]에 일단 여왕을 배치하고
                col[row+1] = i;
                //유망하면 이어서 dfs
                if(isPossible(row+1)){
                    dfs(n, row + 1);
                //유망하지 않다면 여왕 제거
                }else{
                    col[row+1] = 0;
                }
            }
        }
        col[row] = 0;
    }
}
