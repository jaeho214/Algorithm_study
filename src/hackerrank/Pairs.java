package hackerrank;

import java.util.*;

public class Pairs {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,2};
        System.out.println(pairs(2, arr));
    }

    static int pairs(int k, int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a : arr){
            set.add(a);
        }
        int answer = 0;

        for(int num : set){
            if(set.contains(num + k)){
                answer ++;
            }
        }
        return answer;
    }
}
