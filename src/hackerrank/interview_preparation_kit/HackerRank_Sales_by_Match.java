package hackerrank.interview_preparation_kit;

import java.util.HashMap;
import java.util.Map;

public class HackerRank_Sales_by_Match {
    public static void main(String[] args) {
        System.out.println(sockMerchant(9, new int[]{10,20,20,10,10,30,50,10,20}));
    }

    static int sockMerchant(int n, int[] ar) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int a : ar){
            map.put(a, map.getOrDefault(a, 0)+1);
        }

        for (int key : map.keySet()) {
            answer += map.get(key)/2;
        }

        return answer;
    }
}
