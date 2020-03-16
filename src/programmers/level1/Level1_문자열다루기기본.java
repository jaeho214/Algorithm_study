package programmers.level1;

public class Level1_문자열다루기기본 {
    public static void main(String[] args) {
        Level1_문자열다루기기본 level1_문자열다루기기본 = new Level1_문자열다루기기본();
        System.out.println(level1_문자열다루기기본.solution("1abc"));
    }
    public boolean solution(String s) {

        if(s.length() != 4 && s.length() !=6)
            return false;

        for(int i=0;i<s.length();i++){
            if(Character.isLetter(s.charAt(i)))
                return false;

        }
        return true;
    }
}
