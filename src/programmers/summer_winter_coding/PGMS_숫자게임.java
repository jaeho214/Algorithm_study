package programmers.summer_winter_coding;

import java.util.Arrays;

public class PGMS_숫자게임 {
    public static void main(String[] args) {
        PGMS_숫자게임 pgms_숫자게임 = new PGMS_숫자게임();
        int a[] = {2,2,2,2};
        int b[] = {1,1,1,1};
        System.out.println(pgms_숫자게임.solution(a, b));
    }

    /*
     * A : A팀의 숫자
     * B : B팀의 숫자
     */
    public int solution(int[] A, int[] B) {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int idx = B.length;
        for(int i=B.length-1; i>=0; i--){
            while(idx > 0){
                idx--;
                if(B[i] > A[idx]) {
                    answer ++;
                    break;
                }
            }
        }

        return answer;
    }
}
