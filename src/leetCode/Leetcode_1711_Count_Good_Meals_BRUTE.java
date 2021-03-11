package leetCode;

import java.util.*;

/**
 * 모두 map에 넣어주고 반복문을 돌리면 중복된 결과까지 세서 2배의 값이 나왔다.
 * map에 순차적으로 넣어주면서 하니까 중복을 방지할 수 있었다.
 */
public class Leetcode_1711_Count_Good_Meals_BRUTE {
    public static void main(String[] args) {
        Leetcode_1711_Count_Good_Meals_BRUTE count_good_meals = new Leetcode_1711_Count_Good_Meals_BRUTE();
        int[] deliciousness = {1,1,1,3,3,3,7};
        System.out.println(count_good_meals.countPairs(deliciousness));
    }

    public int countPairs(int[] deliciousness) {

        int MOD = 1000000007;

        Map<Integer, Integer> map = new HashMap<>();

        int count = 0;
        //배열을 돌면서
        for(int i=0;i<deliciousness.length; i++){
            //2의 제곱들을 모두 확인
            for(int j=0;j<=20;j++){
                //2의 제곱을 구하고
                int num = (int) Math.pow(2, j);
                //그 2의 제곱-deliciousness[i], 즉 deliciousness[i]와 합해서 2의 제곱을 만들어주는 수가 있다면
                if(map.containsKey(num-deliciousness[i])){
                    //그 수의 개수만큼 카운트한다.
                    count += map.get(num-deliciousness[i]);
                    count %= MOD;
                }
            }
            //확인 후에 map에 넣어준다.
            map.put(deliciousness[i], map.getOrDefault(deliciousness[i], 0)+1);
        }
        return count%MOD;
    }
}
