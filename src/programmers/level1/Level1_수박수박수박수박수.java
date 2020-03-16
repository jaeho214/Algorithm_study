package programmers.level1;

public class Level1_수박수박수박수박수 {
    public static void main(String[] args) {
        Level1_수박수박수박수박수 level1_수박수박수박수박수 = new Level1_수박수박수박수박수();
        System.out.println(level1_수박수박수박수박수.solution(10));
    }
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        if(n % 2 == 0){
            for(int i=0;i<n/2;i++){
                sb.append("수박");
            }
        }else{
            for(int i=0;i<n/2;i++){
                sb.append("수박");
            }
            sb.append("수");
        }
        return sb.toString();
    }
}
