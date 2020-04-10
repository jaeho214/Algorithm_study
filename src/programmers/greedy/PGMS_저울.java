package programmers.greedy;

import java.util.Arrays;

public class PGMS_저울 {
    public static void main(String[] args) {
        int[] weight = {3, 1, 6, 2, 7, 30, 1};
        PGMS_저울 pgms_저울 = new PGMS_저울();
        System.out.println(pgms_저울.solution(weight));
    }

    public int solution(int[] weight) {
        Arrays.sort(weight);
        int num = 1;
        for(int i=0;i<weight.length;i++){
            if(num < weight[i])
                break;
            num += weight[i];
        }
        return num;
    }
}
