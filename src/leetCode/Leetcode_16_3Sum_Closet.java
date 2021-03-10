package leetCode;

import java.util.Arrays;

public class Leetcode_16_3Sum_Closet {
    public static void main(String[] args) {
        Leetcode_16_3Sum_Closet sumCloset = new Leetcode_16_3Sum_Closet();
        int[] nums = {4,0,5,-5,3,3,0,-4,-5};
        System.out.println(sumCloset.threeSumClosest(nums, -2));
    }

    public int threeSumClosest(int[] nums, int target){
        int min = Integer.MAX_VALUE;
        int answer = 0;

        //정렬을 하고
        Arrays.sort(nums);

        //기준점을 잡은 후
        for(int i=0;i<nums.length;i++){
            //기준점의 오른쪽 배열에서 양 끝에서 가운데로 오면서
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                //합을 구하고
                int sum = nums[i] + nums[left] + nums[right];
                //타겟과 합의 차이를 구한다.
                int diff = Math.abs(target - sum);

                //타겟과 합이 같다면 그 합 그대로 리턴
                if(diff == 0)
                    return sum;

                //타겟과 합의 차이를 갱신
                if(diff < min){
                    min = diff;
                    answer = sum;
                }
                //타겟보다 합이 작다면, 즉 더 커져야한다면
                if(sum <= target)
                    //left를 이동
                    left++;
                //더 작아져야한다면
                else
                    //right를 이동
                    right--;
            }
        }

        return answer;
    }
}
