package programmers.level3;

public class Level3_N_Queen_second {
    public static void main(String[] args) {
        Level3_N_Queen_second level3_n_queen_second = new Level3_N_Queen_second();
        System.out.println(level3_n_queen_second.solution(4));
    }
    private int col[];
    private int cnt=0;
    private int n;
    public int solution(int n) {
        this.n = n;
        for(int i=1;i<=n;i++){
            col = new int[n+1];
            col[1] = i;
            dfs(1);
        }
        return cnt;
    }

    private void dfs(int row) {
        if(row == n){
            cnt++;
            return;
        }

        for(int i=1;i<=n;i++){
            col[row+1] = i;
            if(isPossible(row+1)){
                dfs(row+1);
            }else{
                col[row+1] = 0;
            }
        }
        col[row] = 0;
    }

    private boolean isPossible(int row){
        int idx = 1;

        while(idx < row){
            if(col[row] == col[idx] || Math.abs(col[row] - col[idx]) == row-idx)
                return false;
            idx++;
        }
        return true;
    }


}
