package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
/*
 * https://lkhlkh23.tistory.com/113
 */
public class PGMS_라면공장 {

    public static void main(String[] args) {
        int[] dates = {1,2,3,4,5};
        int[] supplies = {1,1,1,1,25};
        PGMS_라면공장 pgms_라면공장 = new PGMS_라면공장();
        System.out.println(pgms_라면공장.solution(4, dates, supplies, 30));
    }

    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;

        //이런식으로 하면 큐에 저장이 될때 크기 역순으로 큐에 들어간다.
        Queue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        //배열을 돌기 위한 인덱스
        int idx = 0;
        //원래 공장에서 공급이 될때까지
        for(int i=0;i<k;i++){
            //만약 해외 공장에서 공급이 되는 날이면
            if(idx < dates.length && i == dates[idx])
                //해외 공장에서 공급되는 날에 공급되는 양을 programmers.heap 에 저장
                heap.add(supplies[idx++]);

            //이 부분은 밀가루가 바닥날 일이 없다는 가정이 있기 때문에 가능한 듯 하다.
            //만약 밀가루가 다 떨어지면
            if(stock == 0){
                //지금까지 programmers.heap 에 저장된 밀가루의 양들 중 가장 많은 양을 stock에 더해주고
                stock += heap.poll();
                //수입 횟수 ++
                answer++;
            }
            //매일 1톤씩 사용
            stock--;
        }
        return answer;
    }
}
