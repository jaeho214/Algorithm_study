package programmers.level2;

public class Level2_N진수게임 {

    public static void main(String[] args) {
        Level2_N진수게임 level2_n진수게임 = new Level2_N진수게임();
        System.out.println(level2_n진수게임.solution(16, 16, 2, 1));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        String convertedStr = convert(n, t, m);

        for(int i=p-1;i<convertedStr.length();i +=m){
            if(answer.length() == t)
                break;
            answer.append(convertedStr.charAt(i));
        }
        return answer.toString();
    }

    public String convert(int n, int t, int m){
        StringBuilder res = new StringBuilder();
        res.append(0);
        int i=1;
        while(true){
            int num = i;
            StringBuilder sb = new StringBuilder();
            while(num > 0){
                int tmp = num%n;
                sb.append(tmp >= 10 ? String.valueOf((char)('A' + (tmp-10))) : tmp);
                num/=n;
            }
            i++;
            res.append(sb.reverse());
            if(res.length() > t*m)
                break;
        }
        return res.toString();
    }
}
