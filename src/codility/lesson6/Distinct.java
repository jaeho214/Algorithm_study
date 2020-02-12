package codility.lesson6;

import java.util.LinkedHashSet;
import java.util.Set;

public class Distinct {
    public static void main(String[] args) {
        int[] arr = {0};
        Distinct distinct = new Distinct();
        System.out.println(distinct.solution(arr));
    }

    public int solution(int[] A) {
        Set<Integer> set = new LinkedHashSet<>();
        for(int a : A)
            set.add(a);
        return set.size();
    }
}
