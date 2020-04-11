package programmers.summer_winter_coding;

import java.util.Arrays;

public class PGMS_예산 {
    public static void main(String[] args) {
        PGMS_예산 pgms_예산 = new PGMS_예산();
        int[] d = {1,3,2,5,4};
        System.out.println(pgms_예산.solution(d, 9));
    }

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        int answer = 0;
        for(int i=0;i<d.length;i++){
            if(sum+d[i] > budget)
                break;
            sum += d[i];
            answer ++;
        }
        return answer;
    }
}
