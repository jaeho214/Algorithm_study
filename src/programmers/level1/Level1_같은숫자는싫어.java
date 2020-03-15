package programmers.level1;

import java.util.ArrayList;
import java.util.List;

public class Level1_같은숫자는싫어 {
    public static void main(String[] args) {
        Level1_같은숫자는싫어 level1_같은숫자는싫어 = new Level1_같은숫자는싫어();
        int[] arr = {1,1,3,3,0,1,1,1};
        System.out.println(level1_같은숫자는싫어.solution(arr));
    }
    public int[] solution(int []arr) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length; i++){
            if(!list.isEmpty() && arr[i-1] == arr[i])
                continue;
            list.add(arr[i]);
        }
        answer = new int[list.size()];

        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }


        return answer;
    }
}
