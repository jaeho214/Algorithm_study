package leetCode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode_1218_Longest_Arithmetic_Subsequence_of_Given_Difference_DP {
    public static void main(String[] args) {
        int[] arr = {1,5,7,8,5,3,4,2,1};
        Leetcode_1218_Longest_Arithmetic_Subsequence_of_Given_Difference_DP l =
                new Leetcode_1218_Longest_Arithmetic_Subsequence_of_Given_Difference_DP();
        System.out.println(l.longestSubsequence(arr, -2));
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();


        for(int i=0;i<arr.length;i++){
            //현재 arr값보다 difference 만큼 작은게 앞에 있었다면
            if(map.containsKey(arr[i]-difference))
                //+1
                map.put(arr[i], map.get(arr[i]-difference)+1);
            else
                map.put(arr[i], 0);
        }

        int answer = 0;
        for(Map.Entry entry : map.entrySet()){
            answer = Math.max(answer, (int)entry.getValue()+1);
        }

        return answer;
    }
}
