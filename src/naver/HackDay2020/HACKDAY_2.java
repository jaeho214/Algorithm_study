package naver.HackDay2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HACKDAY_2 {
    public static void main(String[] args) {
        HACKDAY_2 hackday_2 = new HACKDAY_2();
        String[] id_list = {"A B C D", "A D", "A B D", "B D"};
        System.out.println(hackday_2.solution(id_list, 2));
    }

    public int solution(String[] id_list, int k) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();

        for(String id : id_list){
            String[] arr = id.split(" ");
            List<String> list = new ArrayList<>();
            for(String s : arr){
                if(list.contains(s))
                    continue;
                list.add(s);

                if(!map.containsKey(s)){
                    map.put(s, 1);
                    answer++;
                }else{
                    if(map.get(s) < k){
                        map.put(s, map.getOrDefault(s, 0) + 1);
                        answer++;
                    }else{
                        continue;
                    }
                }
            }
        }
        return answer;
    }

}
