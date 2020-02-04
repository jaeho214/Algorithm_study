package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PGMS_K번째수 {

    public static void main(String[] args) {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1}, {1,7,3}};
        PGMS_K번째수 pgms_k번째수 = new PGMS_K번째수();
        int[] result = pgms_k번째수.solution(array, commands);
        for(int i : result){
            System.out.println(i);
        }
    }


    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        for(int i=0; i<commands.length;i++){
            int start = commands[i][0];
            int end = commands[i][1];
            int target = commands[i][2];
            List<Integer> list = new ArrayList<>();
            for(int j=start-1;j<end;j++){
                list.add(array[j]);
            }
            Collections.sort(list);
            answer[i] = list.get(target-1);
        }
        return answer;
    }
}
