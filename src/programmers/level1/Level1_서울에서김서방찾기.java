package programmers.level1;

public class Level1_서울에서김서방찾기 {
    public static void main(String[] args) {
        Level1_서울에서김서방찾기 level1_서울에서김서방찾기 = new Level1_서울에서김서방찾기();
        String[] str = {"Park", "Kim"};
        System.out.println(level1_서울에서김서방찾기.solution(str));
    }
    public String solution(String[] seoul) {
        for(int i=0;i<seoul.length;i++){
            if(seoul[i].equals("Kim"))
                return "김서방은 " + i + "에 있다";
        }
        return null;
    }
}
