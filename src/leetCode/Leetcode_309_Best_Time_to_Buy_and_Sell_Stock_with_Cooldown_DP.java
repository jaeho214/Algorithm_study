package leetCode;

public class Leetcode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_DP {
    public static void main(String[] args) {
        Leetcode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_DP b = new Leetcode_309_Best_Time_to_Buy_and_Sell_Stock_with_Cooldown_DP();
        int[] prices = {1};
        System.out.println(b.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][3];

        //0은 buy, 1은 sell, 2는 cooldown
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for(int i=1;i<prices.length;i++){
            //이전꺼를 구매하는 것과, 이전에 스킵하고 이번꺼를 구매하는 경우
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][2] - prices[i]);
            //이전꺼를 사서 바로 파는 경우
            dp[i][1] = dp[i-1][0] + prices[i];
            //이전꺼를 판매하고 쉬거나, 연속으로 쉬는 경우
            dp[i][2] = Math.max(dp[i-1][1], dp[i-1][2]);
        }

        return Math.max(Math.max(dp[prices.length-1][0],dp[prices.length-1][1]),dp[prices.length-1][2]);

    }
}
