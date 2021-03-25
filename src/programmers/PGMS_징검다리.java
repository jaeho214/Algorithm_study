package programmers;

import java.util.Arrays;

public class PGMS_징검다리 {
    public static void main(String[] args) {

    }

    public int solution(int distance, int[] rocks, int n) {
        //바위를 정렬하고
        Arrays.sort(rocks);

        int answer = 0;

        //전체 길이를 이분탐색하면서
        int left = 0;
        int right = distance;

        while(left <= right){
            int cnt = 0, prev = 0;
            //mid를 최소값이라고 일단 가정해두고
            int mid = (left+right)/2;

            //prev를 옮겨가면서 최소값보다 작은 것을 지워준다.
            //최소값보다 커야만 prev를 갱신
            for(int i=0;i<rocks.length;i++){
                if(rocks[i] - prev < mid) cnt++;
                else prev = rocks[i];
            }

            //도착지와 마지막 바위도 비교
            if(distance - prev < mid) cnt++;

            //만약 n보다 조금 지웠으면
            //어차피 n보다 적게 지워졌어도 최소값은 변함없으므로
            if(cnt <= n){
                //결과값 갱신
                answer = Math.max(answer, mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }

        return answer;
    }
}
