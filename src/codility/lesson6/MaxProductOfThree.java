package codility.lesson6;

import java.util.Arrays;

public class MaxProductOfThree {

    public static void main(String[] args) {
        MaxProductOfThree maxProductOfThree = new MaxProductOfThree();
        int[] arr = {-3,1,2,-2,5,6};
        System.out.println(maxProductOfThree.solution(arr));
    }


    public int solution(int[] A) {
        int positiveCnt=0, zeroCnt=0;
        Arrays.sort(A);

        for(int i=0;i<A.length;i++){
            if(A[i] > 0)
                positiveCnt ++;
            else if(A[i] == 0)
                zeroCnt ++;
        }

        int len = A.length;
        if(positiveCnt >= 3){
            return Math.max(A[0]*A[1]*A[len-1], A[len-1]*A[len-2]*A[len-3]);
        }else if(positiveCnt >= 1 && positiveCnt <= 2){
            return A[0]*A[1]*A[len-1];
        }else{
            if(zeroCnt > 0){
                return 0;
            }else{
                return Math.max(A[0]*A[1]*A[len-1], A[len-1]*A[len-2]*A[len-3]);
            }
        }
    }
}
