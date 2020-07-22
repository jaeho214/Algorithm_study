package kakao.blind2018;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class KAKAO_추석트래픽_second {

    public static void main(String[] args) throws ParseException {
        KAKAO_추석트래픽_second kakao_추석트래픽_second = new KAKAO_추석트래픽_second();
        String[] lines = {
            "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(kakao_추석트래픽_second.solution(lines));
    }
    public class Pair{
        LocalDateTime start;
        LocalDateTime end;

        public Pair(LocalDateTime start, LocalDateTime end) {
            this.start = start;
            this.end = end;
        }
    }


    public int solution(String[] lines) {
        int answer = 0;


        List<Pair> list = new ArrayList<>();

        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        for(String line : lines) {
            String[] s = line.split(" ");
            String time = s[0] + " " + s[1];
            LocalDateTime to = LocalDateTime.parse(time, format);
            long duration = (long) (Double.parseDouble(s[2].substring(0,s[2].length()-1)) * 1000000000);
            LocalDateTime from = to.minusNanos(duration).plusNanos((long) (0.001 * 1000000000));
            list.add(new Pair(from, to));
        }


        for(int i=0;i<list.size();i++){
            Pair pair = list.get(i);
            long from = Timestamp.valueOf(pair.end).getTime();
            long to = Timestamp.valueOf(pair.end.plusSeconds(1)).getTime();
            int cnt = 0;
            for(int j=0;j<list.size();j++){
                Pair p = list.get(j);
                long start = Timestamp.valueOf(p.start).getTime();
                long end = Timestamp.valueOf(p.end).getTime();

                if(to - start <= 0)
                    continue;
                //to에 걸치는 경우
                if(((from - start) <= 0 && (to - start) > 0)
                        //from 과 to 사이에 들어가는 경우
                        || ((from - end) <= 0 && (to - end) > 0)
                        //from 에 걸치는 경우
                        || ((from - start) > 0 && (from - end) <= 0)) {
                    cnt++;
                }
            }
            answer = Math.max(answer, cnt);
        }

        return answer;
    }
}
