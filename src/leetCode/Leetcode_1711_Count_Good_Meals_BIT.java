package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1711_Count_Good_Meals_BIT {
    public static void main(String[] args) {
        Leetcode_1711_Count_Good_Meals_BIT count_good_meals = new Leetcode_1711_Count_Good_Meals_BIT();
        int[] deliciousness = {1,1,1,3,3,3,7};
        System.out.println(count_good_meals.countPairs(deliciousness));
    }

    public int countPairs(int[] deliciousness){
        int result = 0;
        int MOD = 1000000007;

        Map<Integer, Integer> map = new HashMap<>();

        for(int d : deliciousness){
            for(int i=0;i<=21;i++){
                int sum = 1 << i; // 2의 제곱을 구해서
                if(sum >= d && map.containsKey(sum-d))
                    result = (result + map.get(sum-d)) % MOD;
            }
            map.put(d, map.getOrDefault(d, 0) + 1);
        }

        return result% MOD;
    }
}
