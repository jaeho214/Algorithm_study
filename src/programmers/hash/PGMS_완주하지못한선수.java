package programmers.hash;

import java.util.HashMap;

public class PGMS_완주하지못한선수 {
    public static void main(String[] args) {
        String[] participant= {"leo", "kiki", "eden","eden"};
        String[] completion= {"kiki", "eden", "leo"};
        PGMS_완주하지못한선수 pgms_완주하지못한선수 = new PGMS_완주하지못한선수();
        System.out.println(pgms_완주하지못한선수.solution(participant,completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();

        for(String str : participant) {
            fillMap(str, map);
        }
        for(String str : completion) {
            fillMap(str, map);
        }
        for(String str : participant){
            if(map.get(str) % 2 != 0)
                return str;
        }
        return answer;
    }
    public void fillMap(String str, HashMap<String, Integer> map){
        if (map.containsKey(str)) {
            int value = map.get(str);
            map.put(str, value + 1);
        } else
            map.put(str, 1);
    }
}
