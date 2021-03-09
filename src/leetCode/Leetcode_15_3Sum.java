package leetCode;

import java.util.*;

public class Leetcode_15_3Sum {
    public static void main(String[] args) {
        Leetcode_15_3Sum leetcode_15_3Sum = new Leetcode_15_3Sum();
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
        if(nums.length < 3)
            return new ArrayList<>();

        List<List<Integer>> answer = new ArrayList<>();
        Set<Triplets> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++)
            map.put(nums[i], i);

        int point1 = 0;
        int point2 = 1;

        //왼쪽에서부터 차례로 확인하면서
        while(point1 < nums.length && point2 < nums.length){
            //두 수를 합하고 나머지 값을 타켓으로 해서
            int target = -1 * (nums[point1] + nums[point2]);
            //그 타켓이 배열에 존재하고 인덱스가 다르면(다른 값이면) set에 add
            if(map.containsKey(target) && map.get(target) != point1 && map.get(target) != point2){
                List<Integer> res = Arrays.asList(nums[point1], nums[point2], target);
                Collections.sort(res);
                set.add(new Triplets(res));
            }
            point2++;
            if(point2 == nums.length-1){
                point1++;
                point2 = point1 + 1;
            }
        }

        //객체의 set을 리턴값에 맞춰 변환
        for(Triplets tri : set){
            answer.add(Arrays.asList(tri.first, tri.second, tri.third));
        }

        return answer;
    }
}
