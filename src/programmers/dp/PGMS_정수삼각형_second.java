package programmers.dp;

public class PGMS_정수삼각형_second {
    public static void main(String[] args) {
        PGMS_정수삼각형_second pgms_정수삼각형_second = new PGMS_정수삼각형_second();
        int triangle[][] = {{7}, {3,8}, {8,1,0}, {2,7,4,4}, {4,5,2,6,5}};
        System.out.println(pgms_정수삼각형_second.solution(triangle));
    }

    public int solution(int[][] triangle) {
        int answer = 0;

        int[][] dp = new int[triangle.length][triangle.length];

        dp[0][0] = triangle[0][0];

        for(int i=1;i<triangle.length;i++){
            for(int j=0;j<triangle[i].length;j++){
                if(j==0)
                    dp[i][j] = dp[i-1][j];
                else if(j==triangle[i].length-1)
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]);

                dp[i][j] += triangle[i][j];
                answer = Math.max(answer, dp[i][j]);
            }
        }
        return answer;
    }
}
