package programmers.sort;

import java.util.Arrays;

public class PGMS_가장큰수_second {
    public static void main(String[] args) {
        PGMS_가장큰수_second pgms_가장큰수_second = new PGMS_가장큰수_second();
        int[] numbers = {0,0,0,0};
        System.out.println(pgms_가장큰수_second.solution(numbers));
    }
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();

        String[] numStr = new String[numbers.length];

        for(int i=0;i<numbers.length;i++){
            numStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStr, (o1, o2) -> String.valueOf(Long.parseLong(o1+o2)).compareTo(String.valueOf(Long.parseLong(o2+o1))));
        int cnt =0;
        for(int i=numStr.length-1;i>=0;i--) {
            answer.append(numStr[i]);
            if(numStr[i].equals("0"))
                cnt++;
        }

        if(cnt == numStr.length)
            return "0";

        return answer.toString();
    }
}
