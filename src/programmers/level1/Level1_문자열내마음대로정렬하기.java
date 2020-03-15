package programmers.level1;

import java.util.Arrays;

public class Level1_문자열내마음대로정렬하기 {
    public static void main(String[] args) {
        Level1_문자열내마음대로정렬하기 level1_문자열내마음대로정렬하기 = new Level1_문자열내마음대로정렬하기();
        String[] strings= {"sun", "car", "hat"};
        System.out.println(level1_문자열내마음대로정렬하기.solution(strings, 1));
    }

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings);
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.charAt(n) < o2.charAt(n))
                return -1;
            else if(o1.charAt(n) > o2.charAt(n))
                return 1;
            else{
                return 0;
            }
        });
        return strings;
    }
}
