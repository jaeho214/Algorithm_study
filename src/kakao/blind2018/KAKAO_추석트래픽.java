package kakao.blind2018;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
/*
 * https://readystory.tistory.com/61
 * 모든 시간으로 탐색하는 방법이 무리가 있다고 판단했음에도 혹시나 하고 풀어봤는데 68.2점을 받았다
 * 푸는 방식은 비슷했으나 접근이 달랐다.
 * 1. 나는 LocalDateTime 으로 isBefore, isAfter 메소드를 이용하여 비교하였으나 long 으로 바꿔서 비교하는 것이 더 쉬웠다.
 * 2. 최대한 많은 로그 데이터가 처리되는 시점을 찾기 위해서 하나의 로그 작업이 끝날 때쯤부터 1초를 찾았으면 되었는데 그 생각을 못했다.
 */
public class KAKAO_추석트래픽 {
    public static void main(String[] args) throws ParseException {
        String[] lines = {
                "2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        KAKAO_추석트래픽 kakao_추석트래픽 = new KAKAO_추석트래픽();
        System.out.println(kakao_추석트래픽.solution(lines));
    }
    public int solution(String[] lines) throws ParseException {
        if(lines.length == 1)
            return 1;
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd HH:mm:ss.SSS");
        List<Date> endDateList = new ArrayList<>();
        List<Date> startDateList = new ArrayList<>();
        for(int i=0;i<lines.length;i++){
            String[] line = lines[i].split(" ");
            String date = line[0] + " " + line[1];
            //처리 시간을 int로 계산
            int procMilli = (int) (Double.parseDouble(line[2].substring(0, line[2].length()-1)) * -1000);
            Date endDate = format.parse(date);
            endDateList.add(endDate);
            startDateList.add(addMilli(endDate, procMilli + 1));
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<endDateList.size();i++){
            int cnt = 0;
            //하나의 작업이 끝날때쯤부터 1초를 범위로 두고 계산
            //최대값을 찾아야하므로 종료 직전의 로그를 포함하여 찾으면 되는데 그 생각을 못했다.
            long from = endDateList.get(i).getTime();
            long to = addMilli(endDateList.get(i), 1000).getTime();

            //로그 데이터들을 돌면서
            for (int j=0;j<startDateList.size();j++){
                long start = startDateList.get(j).getTime();
                long end = endDateList.get(j).getTime();
                if(to - start <= 0)
                    continue;
                //from과 to 사이에 로그 데이터의 진행이 겹칠 경우 cnt
                if(((from - start) <= 0 && (to - start) > 0)
                        || ((from - end) <= 0 && (to - end) > 0)
                        || ((from - start) > 0 && (from - end) <= 0)) {
                    cnt++;
                }
            }
            //가장 큰 값을 찾는 과정
            max = Math.max(max, cnt);
        }
        return max;
    }
    //처리 시간만큼을 더해주는 작업
    //음수로 들어오면 빼줌
    private Date addMilli(Date date, int procMilli) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MILLISECOND, procMilli);
        return c.getTime();
    }
}
