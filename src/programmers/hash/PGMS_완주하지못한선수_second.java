package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class PGMS_완주하지못한선수_second {
    public static void main(String[] args) {
        PGMS_완주하지못한선수_second pgms_완주하지못한선수_second = new PGMS_완주하지못한선수_second();
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(pgms_완주하지못한선수_second.solution(participant, completion));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> completionMap = new HashMap<>();

        for(String com : completion){
            completionMap.put(com, completionMap.getOrDefault(com, 0)+1);
        }

        for(String part : participant){
            if(!completionMap.containsKey(part) || completionMap.get(part) <= 0)
                return part;
            completionMap.put(part, completionMap.get(part)-1);
        }

        return answer;
    }
}
