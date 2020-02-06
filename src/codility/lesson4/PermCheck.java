package codility.lesson4;

import java.util.Arrays;

public class PermCheck {

    public static void main(String[] args) {
        PermCheck permCheck = new PermCheck();
        int[] a = {4,1,3,2};
        System.out.println(permCheck.solution(a));
    }

    public int solution(int[] A) {
        Arrays.sort(A);

        for(int i=0;i<A.length;i++){
            if(i+1 != A[i])
                return 0;
        }
        return 1;
    }
}
