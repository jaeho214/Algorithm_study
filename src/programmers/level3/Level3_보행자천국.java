package programmers.level3;

public class Level3_보행자천국 {
    public static void main(String[] args) {
        Level3_보행자천국 level3_보행자천국 = new Level3_보행자천국();
        int[][] cityMap = {{0,2,0,0,0,2}, {0,0,2,0,1,0}, {1,0,0,2,2,0}};
        System.out.println(level3_보행자천국.solution(3, 6, cityMap));
    }

    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] rightArr = new int[m+1][n+1];
        int[][] downArr = new int[m+1][n+1];
        rightArr[1][1] = 1;
        downArr[1][1] = 1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(cityMap[i-1][j-1] == 0){
                    int cnt = (rightArr[i][j-1] + downArr[i-1][j]) % MOD;
                    rightArr[i][j] += cnt;
                    downArr[i][j] += cnt;
                }else if(cityMap[i-1][j-1] == 1){
                    rightArr[i][j] = 0;
                    downArr[i][j] = 0;
                }else{
                    downArr[i][j] = downArr[i-1][j];
                    rightArr[i][j] = rightArr[i][j-1];
                }
            }
        }

        answer = (downArr[m-1][n] + rightArr[m][n-1]) % MOD;
        return answer;
    }
}
