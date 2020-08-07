package programmers.level3;

import java.util.Arrays;

public class Level3_최고의집합_second {
    public static void main(String[] args) {
        Level3_최고의집합_second level3_최고의집합_second = new Level3_최고의집합_second();
        System.out.println(level3_최고의집합_second.solution(2, 9));
    }

    public int[] solution(int n, int s) {
        if(s < n)
            return new int[]{-1};

        int[] answer = new int[n];

        int divide = s / n;
        int remainder = s % n;

        Arrays.fill(answer, divide);

        for(int i=n-1;i>=0;i--){
            if(remainder == 0)
                break;
            answer[i] ++;
            remainder--;
        }


        return answer;
    }
}
