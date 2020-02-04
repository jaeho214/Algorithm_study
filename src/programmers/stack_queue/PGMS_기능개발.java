package programmers.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class PGMS_기능개발 {
    public static void main(String[] args) {
        int[] progresses = {93,30,55};
        int[] speeds = {1,30,5};

        PGMS_기능개발 pgms_기능개발 = new PGMS_기능개발();
        int[] res = pgms_기능개발.solution(progresses, speeds);
        for(int i : res)
            System.out.print(i);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        int[] day = new int[progresses.length];

        for(int i=0;i<progresses.length;i++){
            int cnt = 0;
            while(progresses[i] < 100){
                progresses[i] += speeds[i];
                cnt ++;
            }
            day[i] = cnt;
        }

        int first = day[0];
        int cnt = 1;
        //앞의 기능을 먼저 마무리 해야하기 때문에 max 값을 구하는 방식으로 진행
        for(int i=1;i<day.length;i++){
            if(first < day[i]){
                //기능의 개수를 list에 추가
                list.add(cnt);
                cnt = 1;
                first = day[i];
                continue;
            }
            cnt++;
        }
        list.add(cnt);
        return list.stream().mapToInt(x -> x).toArray();
    }
}
