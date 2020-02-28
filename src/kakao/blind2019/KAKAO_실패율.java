package kakao.blind2019;

import java.util.*;

public class KAKAO_실패율 {

    public class Pair implements Comparable<Pair>{
        int idx;
        float ans;
        public Pair(int idx, float ans) {
            this.idx = idx;
            this.ans = ans;
        }

        @Override
        public int compareTo(Pair pair) {
            if(this.ans < pair.ans){
                return 1;
            }else if(this.ans > pair.ans){
                return -1;
            }else{
                return 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] stages = {4,4,4,4};
        KAKAO_실패율 kakao_실패율 = new KAKAO_실패율();
        System.out.println(kakao_실패율.solution(4, stages));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];

        Arrays.sort(stages);
        Map<Integer, Integer> map = new HashMap<>();
        for(int stage : stages){
            map.put(stage, map.getOrDefault(stage, 0)+1);
        }

        int len = stages.length;
        List<Pair> ans_list = new ArrayList<>();

        for(int i=1;i<=N;i++){
            int cnt = 0;
            if(map.containsKey(i))
                cnt = map.get(i);
            ans_list.add(new Pair(i, (float)cnt/len));
            len -= cnt;
        }
        ans_list.sort(Pair::compareTo);

        for(int i=0;i<ans_list.size();i++){
            answer[i] = ans_list.get(i).idx;
        }

        return answer;
    }
}
