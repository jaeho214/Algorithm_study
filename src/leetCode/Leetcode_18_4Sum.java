package leetCode;

import java.util.*;

public class Leetcode_18_4Sum {
    public static void main(String[] args) {
        Leetcode_18_4Sum leetcode_18_4Sum = new Leetcode_18_4Sum();
        int[] nums ={1,0,-1,0,-2,2};
        System.out.println(leetcode_18_4Sum.fourSum(nums, 0));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Set<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j< nums.length;j++){
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if(sum == target){
                        set.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    }

                    if(sum < target)
                        left ++;
                    else
                        right--;
                }
            }
        }

        return new ArrayList<>(set);
    }
}
