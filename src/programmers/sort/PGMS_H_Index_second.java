package programmers.sort;

import java.util.Arrays;

public class PGMS_H_Index_second {
    public static void main(String[] args) {
        PGMS_H_Index_second pgms_h_index_second = new PGMS_H_Index_second();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(pgms_h_index_second.solution(citations));
    }

    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        int max = citations[citations.length-1];

        while(max >= 0){
            int cnt = 0;
            for(int i=citations.length-1;i>=0;i--){
                if(max <= citations[i])
                    cnt++;
                else
                    break;
            }
            if(cnt >= max && citations.length-max <= max) {
                answer = max;
                break;
            }

            max--;

        }


        return answer;
    }
}
