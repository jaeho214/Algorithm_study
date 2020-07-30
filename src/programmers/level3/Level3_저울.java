package programmers.level3;

import java.util.Arrays;

public class Level3_저울 {
    public static void main(String[] args) {
        Level3_저울 level3_저울 = new Level3_저울();
        int[] weight = {3,1,6,2,7,30,1};
        System.out.println(level3_저울.solution(weight));
    }
    public int solution(int[] weight) {

        Arrays.sort(weight);
        int sum = 1;
        for(int i=0;i<weight.length;i++) {
            if (sum < weight[i])
                break;

            sum += weight[i];
        }
        return sum;
    }

}
