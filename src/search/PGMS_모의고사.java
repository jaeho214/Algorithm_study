package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PGMS_모의고사 {
    public static void main(String[] args) {
        int[] answers = {1,3,2,4,2};
        PGMS_모의고사 pgms_모의고사 = new PGMS_모의고사();
        System.out.println(pgms_모의고사.solution(answers).toString());
    }

    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        int[] arr = new int[3];
        for(int i=0; i<answers.length; i++){
            if(answers[i] == one[i%one.length]){
                arr[0] ++;
            }
            if(answers[i] == two[i%two.length]){
                arr[1] ++;
            }
            if(answers[i] == three[i%three.length]){
                arr[2]++;
            }
        }

        int max = Arrays.stream(arr).max().getAsInt();

        for(int i=0;i<arr.length;i++) {
            if (arr[i] == max) {
                list.add(i+1);
            }
        }


        return list.stream().mapToInt(i -> i.intValue()).toArray();
    }

}
