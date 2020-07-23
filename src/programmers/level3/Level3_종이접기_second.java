package programmers.level3;

public class Level3_종이접기_second {
    public static void main(String[] args) {
        Level3_종이접기_second level3_종이접기_second = new Level3_종이접기_second();
        System.out.println(level3_종이접기_second.solution(3));
    }

    public int[] solution(int n) {
        String[] dp = new String[n];

        dp[0] = "0";
        for(int i=1;i<n;i++){
            dp[i] = dp[i-1] + "0" + reverse(dp[i-1]);
        }

        int[] answer = new int[dp[n-1].length()];
        for(int i=0;i<answer.length;i++){
            answer[i] = dp[n-1].charAt(i) -'0';
        }

        return answer;
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(chars[i] == '1')
                chars[i] = '0';
            else
                chars[i] = '1';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=chars.length-1; i>=0; i--){
            sb.append(chars[i]);
        }

        return sb.toString();
    }
}
