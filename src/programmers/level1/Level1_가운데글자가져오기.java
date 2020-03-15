package programmers.level1;

public class Level1_가운데글자가져오기 {
    public static void main(String[] args) {
        Level1_가운데글자가져오기 level1_가운데글자가져오기 = new Level1_가운데글자가져오기();
        System.out.println(level1_가운데글자가져오기.solution("qwer"));
    }

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        if(s.length() % 2 ==0){
            sb.append(s.charAt(s.length()/2 - 1));
            sb.append(s.charAt(s.length()/2));
        }else{
            return String.valueOf(s.charAt(s.length()/2));
        }
        return sb.toString();
    }
}
