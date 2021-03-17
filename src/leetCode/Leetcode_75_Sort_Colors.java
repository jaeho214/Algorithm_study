package leetCode;

public class Leetcode_75_Sort_Colors {
    public static void main(String[] args) {
        Leetcode_75_Sort_Colors sort_colors = new Leetcode_75_Sort_Colors();
        int[] nums = {2,0,2,1,1,0};
        sort_colors.sortColors(nums);
    }

    public void sortColors(int[] nums) {
        int[] check = new int[3];

        for(int num : nums){
            check[num]++;
        }
        int idx = 0;
        for(int i=0;i<3;i++){
            for(int j=0;j<check[i];j++){
                nums[idx++] = i;
            }
        }
    }

}
