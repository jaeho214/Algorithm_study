package codility.lesson4;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class MissingInteger {

    public static void main(String[] args) {
        int[] a = {1,3,6,4,1,2};
        MissingInteger missingInteger = new MissingInteger();
        System.out.println(missingInteger.solution(a));
    }

    public int solution(int[] A) {
        Arrays.sort(A);
        Set<Integer> set = new LinkedHashSet<>();
        for(int a : A){
            if(a > 0)
                set.add(a);
        }

        if(set.size()==0)
            return 1;
        int idx = 1;
        for(int a : set){
            if(idx != a)
                return idx;
            idx++;
        }

        return idx;
    }
}
