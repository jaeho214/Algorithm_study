package programmers.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Level1_나누어떨어지는숫자배열 {
    public static void main(String[] args) {
        Level1_나누어떨어지는숫자배열 level1_나누어떨어지는숫자배열 = new Level1_나누어떨어지는숫자배열();
        int[] arr = {5,10,14,54};
        System.out.println(level1_나누어떨어지는숫자배열.solution(arr, 5));
    }
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();

        for(int a : arr){
            if(a % divisor == 0){
                list.add(a);
            }
        }

        if(list.size() == 0){
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }



        answer = new int[list.size()];
        for(int i=0;i<list.size();i++)
            answer[i] = list.get(i);
        Arrays.sort(answer);

        return answer;
    }
}
