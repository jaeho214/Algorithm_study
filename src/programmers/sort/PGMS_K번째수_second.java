package programmers.sort;

import java.util.Arrays;

public class PGMS_K번째수_second {
    public static void main(String[] args) {
        PGMS_K번째수_second pgms_k번째수_second = new PGMS_K번째수_second();
        int array[] = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3}, {4,4,1}, {1,7,3}};
        System.out.println(pgms_k번째수_second.solution(array, commands));
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int idx=0; idx<commands.length;idx++){
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int[] tmp = Arrays.copyOfRange(array, i-1, j);

            Arrays.sort(tmp);

            answer[idx] = tmp[k-1];
        }

        return answer;
    }
}
