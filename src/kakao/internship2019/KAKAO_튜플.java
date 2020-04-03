package kakao.internship2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class KAKAO_튜플 {

    public static void main(String[] args) {
        KAKAO_튜플 kakao_튜플 = new KAKAO_튜플();
        System.out.println(kakao_튜플.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }

    public int[] solution(String s) {
        int[] answer = {};
        String[] strArr = s.substring(2, s.length()-2).split("},\\{");
        List<Integer> result = new ArrayList<>();
        Arrays.sort(strArr, Comparator.comparingInt(String::length));

        String str = String.join(",", strArr);
        String[] numbers = str.split(",");

        for(String num : numbers) {
            if (result.contains(Integer.parseInt(num)))
                continue;
            result.add(Integer.parseInt(num));
        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}
