package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;

public class Leetcode_873_Length_of_Longest_Fibonacci_Subsequence_MAP {
    public static void main(String[] args) {
        Leetcode_873_Length_of_Longest_Fibonacci_Subsequence_MAP l = new Leetcode_873_Length_of_Longest_Fibonacci_Subsequence_MAP();
        int[] arr = {1,3,7,11,12,14,18};
        System.out.println(l.lenLongestFibSubseq(arr));
    }

    public int lenLongestFibSubseq(int[] arr) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int[][] dp = new int[arr.length][arr.length];

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                dp[i][j] = 2;
            }
        }

        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int tmp = arr[i] + arr[j];
                if(map.containsKey(tmp)){
                    dp[j][map.get(tmp)] = dp[i][j] + 1;
                }
            }
        }

        int answer = 0;

        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer==2 ? 0 : answer;
    }
}
