package leetCode;

import java.util.*;

public class Leetcode_15_3Sum_sort {
    public static void main(String[] args) {
        Leetcode_15_3Sum_sort leetcode_15_3Sum = new Leetcode_15_3Sum_sort();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(leetcode_15_3Sum.threeSum(nums));
    }

    public static class Triplets{
        int first;
        int second;
        int third;

        public Triplets(List<Integer> list) {
            this.first = list.get(0);
            this.second = list.get(1);
            this.third = list.get(2);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplets)) return false;
            Triplets triplets = (Triplets) o;
            return first == triplets.first && second == triplets.second && third == triplets.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> answer = new ArrayList<>();
        Set<Triplets> set = new HashSet<>();

        // 정렬
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {

            // 정렬된 값 기준으로 투포인터 실행
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    set.add(new Triplets(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                } else if (sum > 0) right--;
                else left++;
            }
        }

        for(Triplets tri : set){
            answer.add(Arrays.asList(tri.first, tri.second, tri.third));
        }

        return answer;

    }
}
