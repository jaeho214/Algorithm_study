package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_Subsets_BITMASKING {
    public static void main(String[] args) {
        LEET_78_Subsets_BITMASKING subsets = new LEET_78_Subsets_BITMASKING();
        int[] arr = {1,2,3,4};
        System.out.println(subsets.subsets(arr));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < 1 << nums.length; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((i & 1 << j) != 0)
                    tmp.add(nums[j]);
            }
            result.add(tmp);
        }
        return result;
    }
}
