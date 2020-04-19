package naver.burning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NAVER_1 {
    public static void main(String[] args) {
        NAVER_1 naver_1 = new NAVER_1();
        String[] a = {"co", "dil", "ity"};
        naver_1.solution(a);
    }

    public int solution(String[] A) {
        int max = 0;
        List<String> list = new ArrayList<>();
        for(int i=0;i<A.length;i++){
            String longStr = A[i];
            for(int j=i+1;j<A.length;j++){
                longStr += A[j];
                String str = A[i] + A[j];
                check(str, list);
                check(longStr, list);
            }
        }

        for(String str : list){
            if(max < str.length())
                max = str.length();
        }

        return max;
    }

    public void check(String str, List<String> list){
        Set<Character> chSet = new HashSet<>();
        for(int k=0;k<str.length();k++){
            chSet.add(str.charAt(k));
        }
        if(chSet.size() == str.length())
            list.add(str);
    }
}
