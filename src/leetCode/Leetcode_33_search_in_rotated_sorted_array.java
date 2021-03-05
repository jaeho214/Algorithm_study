package leetCode;

public class Leetcode_33_search_in_rotated_sorted_array {
    public static void main(String[] args) {
        Leetcode_33_search_in_rotated_sorted_array searchInRotatedSortedArray = new Leetcode_33_search_in_rotated_sorted_array();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(searchInRotatedSortedArray.search(nums, 3));
    }

    public int search(int[] nums, int target) {

        if(nums.length == 1){
            if(nums[0] == target)
                return 0;
            else
                return -1;
        }

        int current = 1;
        int before = 0;

        while(current < nums.length && before < nums.length && nums[current] > nums[before]){
            current++;
            before++;
        }

        int left = binarySearch(0, before, target,nums);
        int right = binarySearch(current, nums.length-1, target, nums);

        return Math.max(left, right);
    }

    private int binarySearch(int start, int end, int target, int[] nums) {

        while(start <= end){
            int mid = (start+end)/2;
            if(nums[mid] == target)
                return mid;

           if(nums[mid] < target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }

        return -1;
    }
}
