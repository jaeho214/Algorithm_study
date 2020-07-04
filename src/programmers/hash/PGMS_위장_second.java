package programmers.hash;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PGMS_위장_second {

    public static void main(String[] args) {
        PGMS_위장_second pgms_위장_second = new PGMS_위장_second();
        String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(pgms_위장_second.solution(clothes));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> cloth = new HashMap<>();

        for(int i=0;i<clothes.length;i++){
            cloth.put(clothes[i][1], cloth.getOrDefault(clothes[i][1], 0)+1);
        }

        Iterator<String> iterator = cloth.keySet().iterator();
        while(iterator.hasNext()){
            answer *= cloth.get(iterator.next()) + 1;
        }
        return --answer;
    }

}
