package dp;

import java.util.Arrays;

public class PGMS_정수삼각형 {
    public static void main(String[] args) {
        int[][] triangle = {{7},{3,8},{8,1,0}, {2,7,4,4}, {4,5,2,6,5}};

        PGMS_정수삼각형 pgms_정수삼각형 = new PGMS_정수삼각형();
        System.out.println(pgms_정수삼각형.solution(triangle));
    }

    public int solution(int[][] triangle) {
        int length = triangle.length;
        int[][] dp = new int[length][length];
        dp[0][0] = triangle[0][0];
        dp[1][0] = triangle[1][0];
        dp[1][1] = triangle[1][1];
        for(int i=1; i<length; i++){
            for(int j=0;j<=i;j++) {
                if (j == 0) {
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                } else if (i==j) {
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        return Arrays.stream(dp[triangle.length-1])
                .max().getAsInt();
    }

}
