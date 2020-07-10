package programmers.search;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PGMS_모의고사_second {
    public static void main(String[] args) {
        PGMS_모의고사_second pgms_모의고사_second = new PGMS_모의고사_second();
        int[] answers = {1};
        System.out.println(pgms_모의고사_second.solution(answers));
    }

    public int[] solution(int[] answers) {
        int[] answer = {};

        int first[] = {1,2,3,4,5};
        int second[] = {2,1,2,3,2,4,2,5};
        int third[] = {3,3,1,1,2,2,4,4,5,5};
        int cnt[] = new int[4];

        for(int i=0;i<answers.length;i++){
            int solve = answers[i];
            if(first[i%first.length] == solve)
                cnt[1] ++;
            if(second[i%second.length] == solve)
                cnt[2] ++;
            if(third[i%third.length] == solve)
                cnt[3] ++;

        }

        int max = Math.max(cnt[1], Math.max(cnt[2], cnt[3]));

        List<Integer> list = new LinkedList<>();
        for(int i=1;i<cnt.length;i++){
            if(cnt[i] == max)
                list.add(i);
        }

        answer = new int[list.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
