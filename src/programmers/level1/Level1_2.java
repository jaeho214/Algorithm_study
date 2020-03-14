package programmers.level1;

public class Level1_2 {
    public static void main(String[] args) {
        Level1_2 level1_2 = new Level1_2();
        System.out.println(level1_2.solution("023337777"));
    }
    public String solution(String phone_number) {

        StringBuilder sb = new StringBuilder();
        String back = phone_number.substring(phone_number.length()-4);
        for(int i=0;i<phone_number.length() - back.length();i++){
            sb.append("*");
        }
        sb.append(back);
        return sb.toString();
    }
}
