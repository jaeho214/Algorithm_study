package programmers.level3;

import java.time.LocalTime;
import java.util.*;

public class Level3_셔틀버스 {
    public static void main(String[] args) {
        Level3_셔틀버스 level3_셔틀버스 = new Level3_셔틀버스();
        String[] timetable = {"23:59"};
        System.out.println(level3_셔틀버스.solution(1,1,1,timetable));
    }

    public String solution(int n, int t, int m, String[] timetable) {

        PriorityQueue<LocalTime> pq = new PriorityQueue<>();
        for(String time : timetable){
            String[] split = time.split(":");
            if(split[0].equals("24")){
                split[0] = "23";
                split[1] = "59";
            }
            pq.add(LocalTime.of(Integer.parseInt(split[0]),Integer.parseInt(split[1])));
        }

        LocalTime start = LocalTime.of(9,0);
        LocalTime time = LocalTime.now();
        for(int i=0;i<n;i++){
            int limit = m;

            time = start;
            while(!pq.isEmpty() && (pq.peek().isBefore(start) || pq.peek().equals(start)) && limit > 0){
                LocalTime poll = pq.poll();

                if(limit == 1){
                    if(time.isAfter(poll) || time.equals(poll)){
                        time = poll.minusMinutes(1);
                    }
                }

                limit--;
            }

            start = start.plusMinutes(t);
        }



        return time.toString();
    }
}
