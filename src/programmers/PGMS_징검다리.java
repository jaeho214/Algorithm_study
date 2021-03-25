package programmers;

import java.util.ArrayList;
import java.util.List;

public class PGMS_징검다리 {
    public static void main(String[] args) {

    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;

        List<Integer> rockList = new ArrayList<>();
        for(int rock : rocks)
            rockList.add(rock);

        rockList.add(0);
        rockList.add(distance);

        int left = 0;
        int right = distance;

        while(left < right){
            int mid = (left+right)/2;

        }

        return answer;
    }
}
