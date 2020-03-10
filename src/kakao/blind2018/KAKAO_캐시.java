package kakao.blind2018;

import java.util.LinkedList;
import java.util.List;

public class KAKAO_캐시 {
    public static void main(String[] args) {
        KAKAO_캐시 kakao_캐시 = new KAKAO_캐시();
        String[] cities = {"Jeju", "Jeju", "Jeju", "Jeju"};
        System.out.println(kakao_캐시.solution(2,cities));

    }

    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length*5;

        int answer = 0;
        List<String> q = new LinkedList<>();

        for(String city : cities){
            if(!q.contains(city.toUpperCase())){
                answer += 5;
                if(q.size() == cacheSize){
                    q.remove(0);
                    q.add(city.toUpperCase());
                }else if(q.size() < cacheSize){
                    q.add(city.toUpperCase());
                }
            }else{
                answer ++;
                q.remove(city.toUpperCase());
                q.add(city.toUpperCase());
            }

        }
        return answer;
    }
}
