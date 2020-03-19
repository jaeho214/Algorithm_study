package programmers.level2;

import java.util.HashSet;
import java.util.Set;

public class Level2_폰켓몬 {
    public static void main(String[] args) {
        Level2_폰켓몬 level2_폰켓몬 = new Level2_폰켓몬();
        int[] nums = {3,1,2,3};
        System.out.println(level2_폰켓몬.solution(nums));
    }
    public int solution(int[] nums) {
        int len = 0;
        if(nums.length % 2 ==0)
            len = nums.length/2;
        else
            len = nums.length/2 + 1;

        Set<Integer> set = new HashSet<>();

        for(int num : nums)
            set.add(num);

        if(set.size() > len)
            return len;
        else
            return set.size();
    }
}
