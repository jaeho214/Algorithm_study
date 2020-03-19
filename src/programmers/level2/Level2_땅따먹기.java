package programmers.level2;

public class Level2_땅따먹기 {
    int dp[][];
    public static void main(String[] args) {
        int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
        Level2_땅따먹기 level2_땅따먹기 = new Level2_땅따먹기();
        System.out.println(level2_땅따먹기.solution(land));
    }

    int solution(int[][] land) {

        int answer = 0;
        dp = new int[land.length][land[0].length];

        for(int i=0;i<4;i++){
            dp[0][i] = land[0][i];
        }

        for(int i=1;i<land.length;i++){
            for(int j=0;j<4;j++){
                dp[i][j] = getMax(dp, i, j) + land[i][j];
            }
        }

        for(int i=0;i<4;i++){
            answer = Math.max(answer,dp[land.length-1][i]);
        }
        return answer;
    }

    private int getMax(int[][] dp, int i, int j) {
        int max = Integer.MIN_VALUE;
        for(int k=0;k<4;k++){
            if(k==j)
                continue;
            max = Math.max(max, dp[i-1][k]);
        }
        return max;
    }
}
