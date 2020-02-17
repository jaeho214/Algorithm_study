package codility.lesson10;

import java.util.LinkedHashSet;
import java.util.Set;

public class CountFactors {

    public static void main(String[] args) {
        CountFactors countFactors = new CountFactors();
        System.out.println(countFactors.solution(2147483647));
    }

    public int solution(int N) {
        Set<Integer> set = new LinkedHashSet<>();

        for(int i=1;i<=N;i++){
            if(i > N/i)
                break;
            if(N%i==0){
                set.add(i);
                set.add(N/i);
            }
        }
        return set.size();
    }
}
