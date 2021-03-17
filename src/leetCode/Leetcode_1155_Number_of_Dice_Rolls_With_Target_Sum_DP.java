package leetCode;

public class Leetcode_1155_Number_of_Dice_Rolls_With_Target_Sum_DP {
    public static void main(String[] args) {
        Leetcode_1155_Number_of_Dice_Rolls_With_Target_Sum_DP n = new Leetcode_1155_Number_of_Dice_Rolls_With_Target_Sum_DP();
        System.out.println(n.numRollsToTarget(2,5,10));
    }

    public int numRollsToTarget(int d, int f, int target) {
        int[][] dp = new int[d+1][target+1];

        dp[0][0] = 1;
        int MOD = 1000000007;

        for(int i=1;i<=d;i++){
            for(int j=1;j<=target;j++){
                int answer = 0;
                for(int k=1;k<=f;k++){
                    if(j-k>=0) {
                        answer += dp[i - 1][j - k];
                        answer %= MOD;
                    }
                }
                dp[i][j] = answer;
            }
        }

        return dp[d][target];
    }
}
