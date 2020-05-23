package programmers.summer;

import java.util.HashSet;
import java.util.Set;

public class SUMMER_1 {
    public static void main(String[] args) {
        SUMMER_1 summer_1 = new SUMMER_1();
        System.out.println(summer_1.solution(9875));
    }

    public int solution(int p) {
        p++;

        while(solve(p)){
            p++;
        }
        return p;
    }

    private boolean solve(int num) {
        String str = String.valueOf(num);

        Set<Character> set = new HashSet<>();

        for(int i=0;i<str.length();i++){
            set.add(str.charAt(i));
        }

        if(set.size() == str.length())
            return false;
        else
            return true;
    }
}
