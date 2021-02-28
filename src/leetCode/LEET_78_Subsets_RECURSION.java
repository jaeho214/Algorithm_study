package leetCode;

import java.util.ArrayList;
import java.util.List;

public class LEET_78_Subsets_RECURSION {
    public static void main(String[] args) {
        LEET_78_Subsets_RECURSION subsets = new LEET_78_Subsets_RECURSION();
        int[] arr = {1,2,3};
        System.out.println(subsets.subsets(arr));
    }
    boolean[] visited;
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        visited = new boolean[nums.length];

        recursion(0, nums);

        return answer;
    }

    private void recursion(int x, int[] nums) {

        List<Integer> tmp = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(visited[i])
                tmp.add(nums[i]);
        }
        answer.add(tmp);

        for(int i=x;i<nums.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            recursion(i, nums);
            visited[i] = false;
        }
    }
}
