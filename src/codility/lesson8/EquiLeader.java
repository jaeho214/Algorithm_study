package codility.lesson8;

import java.util.*;

public class EquiLeader {

    public static void main(String[] args) {
        int[] a = {4,3,4,4,4,2};
        EquiLeader equiLeader = new EquiLeader();
        System.out.println(equiLeader.solution(a));
    }

    public int solution(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int a : A)
            map.put(a, map.getOrDefault(a, 0)+1);

        Iterator<Integer> iterator = map.keySet().iterator();
        int max = 0,idx=0;
        while(iterator.hasNext()){
            int num = iterator.next();
            if(map.get(num) > idx){
                idx = map.get(num);
                max = num;
            }
        }
        int res = 0;
        int maxCnt = 0;
        for(int i=0;i<A.length;i++){
            if(A[i] == max)
                maxCnt ++;
            if(maxCnt > (i+1)/2 && idx-maxCnt >(A.length-i-1)/2)
                res ++;
        }


        return res;
    }
}
