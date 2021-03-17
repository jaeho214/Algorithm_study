package leetCode;

public class Leetcode_1658_Minimum_Operations_to_Reduce_X_to_Zero_TWOPOINTER {
    public static void main(String[] args) {
        Leetcode_1658_Minimum_Operations_to_Reduce_X_to_Zero_TWOPOINTER minimum_operations_to_reduce_x_to_zero =
                new Leetcode_1658_Minimum_Operations_to_Reduce_X_to_Zero_TWOPOINTER();
        int[] nums = {3,2,20,1,1,3};
        System.out.println(minimum_operations_to_reduce_x_to_zero.minOperations(nums, 10));
    }

    public int minOperations(int[] nums, int x) {

        if(nums.length == 1){
            if(nums[0] == x) return 1;
            else return -1;
        }

        int answer = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = nums[0];

        int total = 0;

        for(int num : nums){
            total += num;
        }

        int target = total-x;

        while(left < nums.length && right<nums.length){
            if(sum <= target){
                if(sum == target)
                    answer = Math.min(answer, left + nums.length-right-1);

                right++;
                if(right == nums.length)
                    break;
                sum += nums[right];
            }else{
                sum -= nums[left];
                left++;
            }
        }

        return answer==Integer.MAX_VALUE ? -1 : answer;
    }
}
