package programmers;

import java.util.*;

public class PGMS_보석쇼핑 {
    public static void main(String[] args) {
        PGMS_보석쇼핑 pgms_보석쇼핑 = new PGMS_보석쇼핑();
        String[] gems = {"A", "A", "B"};
        System.out.println(pgms_보석쇼핑.solution(gems));

    }

    public int[] solution(String[] gems) {
        int min = Integer.MAX_VALUE;
        int[] answer = {};

        Queue<String> q = new LinkedList<>();
        Set<String> gemSet = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();

        //보석의 개수를 구하고
        for(String gem : gems){
            gemSet.add(gem);
        }

        //보석이 한 개이거나 한 종류면 {1,1}로 리턴
        if(gems.length == 1 || gemSet.size() == 1)
            return new int[]{1, 1};

        int left = 1;
        int right = 0;
        //보석들을 돌면서
        for(String gem : gems) {
            //right 인덱스를 늘려주고 큐와 맵에 삽입
            right++;
            q.offer(gem);
            map.put(gem, map.getOrDefault(gem, 0) + 1);


            //큐에 모든 종류의 보석이 들어왔고 1개 이상인 동안에
            while(map.size() == gemSet.size() && map.get(q.peek()) >= 1) {
                //현재 인덱스값으로 최소값을 구하고
                if (min > q.size()) {
                    min = q.size();
                    answer = new int[]{left, right};
                }

                if(map.get(q.peek())== 1)
                    break;

                //큐에서 중복되는 것들을 poll
                map.put(q.peek(), map.get(q.peek()) - 1);
                q.poll();
                left++;
            }

        }

        return answer.length ==0 ? new int[]{left, right} : answer;
    }
}
