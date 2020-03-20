package programmers.level2;

public class Level2_JadenCase문자열만들기 {
    public static void main(String[] args) {
        Level2_JadenCase문자열만들기 level2_jadenCase문자열만들기 = new Level2_JadenCase문자열만들기();
        System.out.println(level2_jadenCase문자열만들기.solution("hI "));
    }
    public String solution(String s) {
        s = " " + s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == ' ' && Character.isLetter(s.charAt(i))){
                sb.append(Character.toUpperCase(s.charAt(i)));
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
