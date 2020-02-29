package kakao.blind2019;

import java.util.*;

public class KAKAO_무지의먹방라이브 {
    public class Pair implements Comparable<Pair>{
        int idx;
        int time;
        public Pair(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.time > o.time)
                return 1;
            if(this.time < o.time)
                return -1;
            return 0;
        }
    }
    public static void main(String[] args) {
        int[] food_times = {3,1,2};
        KAKAO_무지의먹방라이브 kakao_무지의먹방라이브 = new KAKAO_무지의먹방라이브();
        System.out.println(kakao_무지의먹방라이브.solution(food_times, 5));
    }

    public int solution(int[] food_times, long k) {
        List<Pair> list = new ArrayList<>();
        boolean check = false;
        for(int i=0;i<food_times.length;i++){
            list.add(new Pair(i+1, food_times[i]));
        }
        list.sort(Pair::compareTo);

        int before = 0;
        int len = food_times.length;
        for(int i=0;i<list.size();i++){
            long min = list.get(i).time - before;
            if(min == 0) {
                len --;
                continue;
            }
            long num = min * len;
            if(num <= k){
                k -= num;
                before = list.get(i).time;
                len--;
            }else {
                k %= len;
                list = list.subList(i, food_times.length);
                check = true;
                break;
            }
        }
        if(!check)
            return -1;


        Collections.sort(list, (o1, o2) -> {
            if(o1.idx > o2.idx)
                return 1;
            return -1;
        });

        return list.get((int)k).idx;
    }
}
