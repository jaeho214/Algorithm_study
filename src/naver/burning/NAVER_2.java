package naver.burning;

import java.util.ArrayList;
import java.util.List;

public class NAVER_2 {
    public static void main(String[] args) {
        NAVER_2 naver_2 = new NAVER_2();
        System.out.println(naver_2.solution("?a?"));
    }

    public String solution(String S) {
        List<Character> list = new ArrayList<>();
        int length = S.length();
        for(int i = 0;i<length;i++){
            if(length % 2 != 0 && i==(length/2)) {
                list.add('a');
                continue;
            }
            list.add(S.charAt(i));
        }

        for(int i=0, j=length-1; i<=length/2; i++, j--){
            if(list.get(i) == list.get(j)){
                if(list.get(i) == '?' && list.get(j) == '?'){
                    list.set(i, 'a');
                    list.set(j, 'a');
                }
                continue;
            }
            if(list.get(i) != list.get(j)){
                if(list.get(i) == '?'){
                    list.set(i, list.get(j));
                }else if(list.get(j) == '?'){
                    list.set(j, list.get(i));
                }else{
                    return "NO";
                }

            }
        }
        String res = "";
        for(Character ch : list){
            res += ch;
        }
        return res;
    }


}
