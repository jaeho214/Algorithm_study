package leetCode;

public class Leetcode_357_Count_Numbers_with_Unique_Digits {
    public static void main(String[] args) {
        Leetcode_357_Count_Numbers_with_Unique_Digits c = new Leetcode_357_Count_Numbers_with_Unique_Digits();
        System.out.println(c.countNumbersWithUniqueDigits(4));
    }

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[9];

        dp[0] = 1;
        dp[1] = 10;
        dp[2] = 91;

        int num = 8;
        int mul = 1;
        int common = 81;
        for(int i=3;i<=n;i++){
            mul *= num--;
            dp[i] = (mul * common) + dp[i-1];
        }

        return dp[n];
    }
}
