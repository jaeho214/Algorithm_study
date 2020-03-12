package kakao.blind2018;

import java.util.*;

public class KAKAO_뉴스클러스터링 {
    public static void main(String[] args) {
        KAKAO_뉴스클러스터링 kakao_뉴스클러스터링 = new KAKAO_뉴스클러스터링();
        System.out.println(kakao_뉴스클러스터링.solution("E=M*C^2", "e=m*c^2"));
    }
    Map<String, Integer> union= new HashMap<>();
    Map<String, Integer> intersection = new HashMap<>();

    public int solution(String str1, String str2) {
        Map<String, Integer> str1_map = addMap(str1);
        Map<String, Integer> str2_map = addMap(str2);

        count(str2_map, str1_map);

        int unionSum = 0;
        int intersectionSum = 0;
        for(String key : union.keySet()){
           unionSum += union.get(key);
        }
        for(String key : intersection.keySet()){
            intersectionSum += intersection.get(key);
        }

        double res = (double)intersectionSum/unionSum;
        
        return (int) (res*65536);
    }
    private void count(Map<String, Integer> str1, Map<String,Integer> str2){
        for(String key : str1.keySet()){
            if(str2.containsKey(key)){
                intersection.put(key, Math.min(str1.get(key), str2.get(key)));
                union.put(key, Math.max(str1.get(key), str2.get(key)));
            }
            else {
                union.put(key, str1.get(key));
            }
        }
        for(String key : str2.keySet()){
            if(!union.containsKey(key))
                union.put(key, str2.get(key));
        }
    }
    private Map<String, Integer> addMap(String str){
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<str.length()-1;i++){
            StringBuilder sb = new StringBuilder();
            if(!Character.isLetter(str.charAt(i)) || !Character.isLetter(str.charAt(i+1)))
                continue;
            sb.append(str.charAt(i));
            sb.append(str.charAt(i+1));

            map.put(sb.toString().toUpperCase(), map.getOrDefault(sb.toString().toUpperCase(), 0)+1);
        }

        return map;
    }
}
