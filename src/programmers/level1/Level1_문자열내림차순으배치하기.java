package programmers.level1;

import com.sun.deploy.util.UpdateCheck;

import java.util.*;

public class Level1_문자열내림차순으배치하기 {
    public static void main(String[] args) {
        Level1_문자열내림차순으배치하기 level1_문자열내림차순으배치하기 = new Level1_문자열내림차순으배치하기();
        System.out.println(level1_문자열내림차순으배치하기.solution("ZEFesfdf"));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        List<Character> lowerList = new ArrayList<>();
        List<Character> upperList = new ArrayList<>();

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                lowerList.add(s.charAt(i));
            }else if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){
                upperList.add(s.charAt(i));
            }
        }
        Collections.sort(lowerList, Collections.reverseOrder());
        Collections.sort(upperList, Collections.reverseOrder());

        for(char ch : lowerList){
            sb.append(ch);
        }
        for(char ch : upperList){
            sb.append(ch);
        }


        return sb.toString();
    }
}
