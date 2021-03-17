package leetCode;

public class Leetcode_457_Circular_Array_Loop_TWOPOINTER {
    public static void main(String[] args) {
        Leetcode_457_Circular_Array_Loop_TWOPOINTER circular_array_loop = new Leetcode_457_Circular_Array_Loop_TWOPOINTER();
        int[] nums = {-1,2};
        System.out.println(circular_array_loop.circularArrayLoop(nums));
    }
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                int pt1 = i;
                int pt2 = i;
                visited[i] = true;
                while (true) {
                    int pt1next = pt1 + nums[pt1];
                    if (pt1next >= n) {
                        pt1next %= n;
                    } else if (pt1next < 0) {
                        pt1next %= n;
                        if (pt1next < 0) pt1next += n;
                    }
                    if (pt1 == pt1next || nums[pt1] * nums[pt1next] < 0) {
                        break;
                    }
                    pt1 = pt1next;
                    visited[pt1] = true;


                    int pt2next = pt2 + nums[pt2];
                    if (pt2next >= n) {
                        pt2next %= n;
                    } else if (pt2next < 0) {
                        pt2next %= n;
                        if (pt2next < 0) pt2next += n;
                    }
                    if (pt2 == pt2next || nums[pt2] * nums[pt2next] < 0) {
                        break;
                    }
                    pt2 = pt2next;
                    visited[pt2] = true;


                    pt2next = pt2 + nums[pt2];
                    if (pt2next >= n) {
                        pt2next %= n;
                    } else if (pt2next < 0) {
                        pt2next %= n;
                        if (pt2next < 0) pt2next += n;
                    }
                    if (pt2 == pt2next || nums[pt2] * nums[pt2next] < 0) {
                        break;
                    }
                    pt2 = pt2next;
                    visited[pt2] = true;


                    if (pt1 == pt2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
