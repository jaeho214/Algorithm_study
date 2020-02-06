package codility.lesson4;

import java.util.HashSet;
import java.util.Set;

public class FrogRiverOne {
    public static void main(String[] args) {
        int[] a = {1,3,1,4,2,3,5,4};
        FrogRiverOne frog = new FrogRiverOne();
        System.out.println(frog.solution(5, a));
    }

    public int solution(int X, int[] A) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<A.length;i++){
            set.add(A[i]);
            if(set.size() == X){
                return i;
            }
        }
        return -1;
    }
}
