package programmers;

public class PGMS_정수삼각형 {
    public static void main(String[] args) {
        PGMS_정수삼각형 pgms_정수삼각형_DP = new PGMS_정수삼각형();
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(pgms_정수삼각형_DP.solution(triangle));
    }

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<=i;j++){
                if(j==0)
                    dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j==i)
                    dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
        }

        for(int num : dp[triangle.length-1])
            answer = Math.max(num, answer);

        return answer;
    }
}
