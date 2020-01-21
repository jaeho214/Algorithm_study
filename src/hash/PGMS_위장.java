package hash;

import java.util.*;

public class PGMS_위장 {

    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        PGMS_위장 pgms_위장 = new PGMS_위장();
        System.out.println(pgms_위장.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for(String[] cloth : clothes){
            map.put(cloth[1], map.getOrDefault(cloth[1], 0) + 1);
        }
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            int num = map.get(key);
            answer *= num + 1;
        }
        // A + B + C + AC + BC + CA + ABC == (A+1)(B+1)(C+1)-1

        return --answer;
    }
}
