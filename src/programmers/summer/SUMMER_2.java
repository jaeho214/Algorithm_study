package programmers.summer;

import java.util.ArrayList;
import java.util.List;

public class SUMMER_2 {
    public static void main(String[] args) {
        SUMMER_2 summer_2 = new SUMMER_2();
        System.out.println(summer_2.solution(9999999));
    }

    public long solution(long n) {

        List<Long> list = new ArrayList<>();
        List<Long> res = new ArrayList<>();
        long num = 0;

        while(true){
            num ++;
            if(3+4*(num-1) >= n)
                break;
        }

        for(int i=0;i<=num;i++){
            list.add((long) Math.pow(3, i));
        }

        for(int j=0;j<(1<<list.size()); j++){
            long tmp = 0;

            for(int k=0;k<list.size();k++){
                if((j & (1<<k)) != 0){
                    tmp += list.get(k);
                }
            }
            if(tmp == 0 || res.contains(tmp))
                continue;

            res.add(tmp);

            if(res.size() == n)
                break;
        }

        return res.get(res.size()-1);

    }
}
