package codility.lesson8;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Dominator {
    public static void main(String[] args) {
        int[] a = {3,4,3,2,3,-1,3,3};
        Dominator dominator = new Dominator();
        System.out.println(dominator.solution(a));
    }

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A)
            map.put(a, map.getOrDefault(a,0)+1);

        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            int key = iterator.next();
            if(map.get(key) > A.length/2){
                for(int i=0;i<A.length;i++){
                    if(A[i] == key)
                        return i;
                }
            }

        }

        return -1;
    }
}
