package programmers.heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/*
 * https://developerdk.tistory.com/22
 */
public class PGMS_디스크컨트롤러 {
    public class Job implements Comparable<Job>{
        int requestTime;
        int workTime;
        public Job(int requestTime, int workTime) {
            this.requestTime = requestTime;
            this.workTime = workTime;
        }

        //heap에 저장될 때 자동 실행
        @Override
        public int compareTo(Job o) {
            //작업 시간순으로 정렬
            if (this.workTime < o.workTime) return -1;
            //작업 시간이 같으면
            else if (this.workTime == o.workTime) {
                //요청시간을 기준으로 정렬
                if (this.requestTime < o.requestTime) return -1;
                else return 1;
            } else return 1;
        }
    }

    public static void main(String[] args) {
        PGMS_디스크컨트롤러 pgms_디스크컨트롤러 = new PGMS_디스크컨트롤러();
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(pgms_디스크컨트롤러.solution(jobs));
    }

    public int solution(int[][] jobs) {
        PriorityQueue<Job> heap = new PriorityQueue<>();
        List<Job> list = new ArrayList<>();

        for(int i=0;i<jobs.length;i++){
            heap.offer(new Job(jobs[i][0], jobs[i][1]));
        }

        for (int i = 0; i < jobs.length; i++) {
            list.add(heap.poll());
        }

        int time=0, sum = 0;
        while(list.size() > 0){
            for(int i=0;i<list.size();i++){
                //현재 시간이 이미 요청이 들어온 후라면
                if(time >= list.get(i).requestTime){
                    //작업을 실행하여 time에 추가해주고
                    time += list.get(i).workTime;
                    //현재 시간에서 요청 시간을 빼서 sum에 더해준다.
                    sum += time - list.get(i).requestTime;
                    list.remove(i);
                    break;
                }
                if(i == list.size() -1)
                    time ++;
            }
        }

        return sum/jobs.length;
    }
}
