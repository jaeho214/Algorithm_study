package kakao.blind2018;

import java.time.LocalTime;
import java.util.PriorityQueue;
/*
 * https://duzi077.tistory.com/153
 * 내가 처음에 생각했던 방법과 비슷했다
 * 나는 구현을 제대로 하지 못했나보다
 */
public class KAKAO_셔틀버스 {
    public String solution(int n, int t, int m, String[] timetable) {
        LocalTime time = null;
        PriorityQueue<LocalTime> q = new PriorityQueue<>();
        for (String str : timetable){
            String[] split = str.split(":");
            if(split[0].equals("24"))
                continue;
            q.add(LocalTime.of(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }

        LocalTime startAt = LocalTime.of(9,0);

        for(int i=0;i<n;i++){
            //최대 인원을 limit로 놓고
            int limit = m;
            //맨 처음에는 plus 되지 않게끔
            if(i != 0)
                startAt = startAt.plusMinutes(t);

            //콘이 탈 시간을 셔틀 시간으로 일단 초기화
            time = startAt;

            //대기열에 크루들이 있고, 빈 자리가 있고, 대기하던 크루들 중 맨 앞의 크루가 셔틀시간보다 먼저 나와있는 동안에
            while(!q.isEmpty() && limit>0 && q.peek().compareTo(startAt) <= 0){
                //크루의 대기 시간을 큐에서 꺼낸다
                LocalTime crew = q.poll();

                //한자리가 남았을 때
                if(limit == 1) {
                    //콘의 시간이 크루의 시간보다 더 늦다면
                    if (time.compareTo(crew) >= 0) {
                        //크루의 시간보다 1분 일찍 나온다
                        time = crew;
                        time = time.minusMinutes(1);
                    }
                }
                //한명 탑승
                limit --;
            }

        }
        return time.toString();

    }

    public static void main(String[] args) {
        KAKAO_셔틀버스 kakao_셔틀버스 = new KAKAO_셔틀버스();
        String[] timetable = {"24:00"};
        System.out.println(kakao_셔틀버스.solution(2,10,2, timetable));
    }
}
