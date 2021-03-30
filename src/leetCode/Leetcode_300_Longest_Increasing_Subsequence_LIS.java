package leetCode;

import java.util.Arrays;

public class Leetcode_300_Longest_Increasing_Subsequence_LIS {
    public static void main(String[] args) {
        Leetcode_300_Longest_Increasing_Subsequence_LIS lis = new Leetcode_300_Longest_Increasing_Subsequence_LIS();
        int[] nums = {0,1,0,3,2,3};
        System.out.println(lis.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int idx = 1;

        for(int i=1;i<nums.length;i++){
            //dp의 마지막 값보다 크다면 갱신해주고
            if(dp[idx-1] < nums[i]){
                dp[idx++] = nums[i];
            //dp의 마지막 값보다 작거나 같다면
            }else{
                //그 값이 dp에서 들어갈 적절한 위치를 찾아서
                int temp = Arrays.binarySearch(dp, 0, idx, nums[i]);
                //그 위치를 갱신해준다.
                dp[temp < 0? -temp-1 : temp] = nums[i];
            }
        }

        return idx;
    }
}
