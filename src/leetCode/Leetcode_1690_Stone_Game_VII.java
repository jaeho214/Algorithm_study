package leetCode;

import java.util.Arrays;

public class Leetcode_1690_Stone_Game_VII {
    public static void main(String[] args) {
        Leetcode_1690_Stone_Game_VII stone_game_vii = new Leetcode_1690_Stone_Game_VII();
        int[] stones = {5,3,1,4,2};
        System.out.println(stone_game_vii.stoneGameVII(stones));
    }

    private int[][] dp;
    public int stoneGameVII(int[] stones) {
        dp = new int[stones.length][stones.length];

        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i], -1);
        }

        int sum = 0;
        for(int stone : stones) sum += stone;

        return recursion(stones, 0, stones.length-1, sum);
    }

    private int recursion(int[] stones, int start, int end, int sum) {
        if(start>end) return 0;

        if(dp[start][end] != -1) return dp[start][end];

        return dp[start][end] = Math.max(sum - stones[start]-recursion(stones, start+1, end, sum-stones[start]),
                sum - stones[end]-recursion(stones, start, end-1, sum-stones[end]));
    }
}
