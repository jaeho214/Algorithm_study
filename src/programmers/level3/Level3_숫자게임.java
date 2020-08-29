package programmers.level3;

import java.util.Arrays;

public class Level3_숫자게임 {

    public static void main(String[] args) {
        Level3_숫자게임 level3_숫자게임 = new Level3_숫자게임();
        int[] A = {5,1,3,7};
        int[] B = {2,2,6,8};
        System.out.println(level3_숫자게임.solution(A, B));
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int aIdx=0, bIdx=0;

        while(aIdx < A.length && bIdx < B.length){
            if(A[aIdx] < B[bIdx]){
                answer++;
                aIdx++;
                bIdx++;
                continue;
            }
            bIdx++;
        }

        return answer;
    }
}
