package kakao.blind2020;

import java.util.ArrayList;
import java.util.List;

public class KAKAO_문자열압축 {
    public static void main(String[] args) {
        KAKAO_문자열압축 kakao_문자열압축 = new KAKAO_문자열압축();
        System.out.println(kakao_문자열압축.solution("a"));
    }
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();

        if(len == 1)
            return 1;

        for(int i=1;i<=len/2;i++){
            String sFake = s;
            List<String> list = new ArrayList<>();
            while(!sFake.equals("")){
                if(sFake.length() < i){
                    list.add(sFake);
                    sFake = "";
                    continue;
                }
                list.add(sFake.substring(0,i));
                sFake = sFake.substring(i);
            }
            list.add(" ");
            int cnt = 1;
            String res = "";
            for(int j=1;j<list.size();j++) {
                if (list.get(j).equals(list.get(j - 1))) {
                    cnt++;
                    continue;
                }
                if(cnt == 1){
                    res += list.get(j-1);
                }else if(cnt > 1){
                    res += cnt+list.get(j-1);
                    cnt = 1;
                }
            }
            answer = Math.min(res.length(), answer);
        }
        return answer;
    }
}
