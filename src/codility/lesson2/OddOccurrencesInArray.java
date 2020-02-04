package codility.lesson2;


import java.util.HashSet;
import java.util.Set;

public class OddOccurrencesInArray {

    public static void main(String[] args) {
        OddOccurrencesInArray odd = new OddOccurrencesInArray();
        int A[] = {9,3,9,3,9,7,9};
        System.out.println(odd.solution(A));
    }

    public int solution(int[] A) {
        //리스트는 정수의 경우 인덱스로만 지울수 있었다.
        //셋은 해당 정수를 지울 수 있었다.
        Set<Integer> set = new HashSet<>();

        for(int a : A){
            if(set.contains(a))
                set.remove(a);
            else
                set.add(a);
        }

        return set.iterator().next();
    }
}
