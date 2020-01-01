package greedy;

import java.util.Arrays;

public class PGMS_체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {1,3,5};
        int[] reserve = {2,3,4};
        int res = solution(n, lost, reserve);
        System.out.println(res);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int res[] = new int[n];

        //모두 체육복을 하나씩 가지고 있음
        Arrays.fill(res, 1);

        //체육복을 도난당한 사람들의 체육복 개수 --
        for(int i=0;i<lost.length;i++)
            res[lost[i]-1] --;

        //여벌의 체육복을 가져온 사람들 체육복 개수 ++
        for(int i=0;i<reserve.length;i++)
            res[reserve[i]-1] ++;

        //체육복 개수 정보가 들어있는 배열 res 를 돌면서
        for(int i=0;i<res.length;i++){
            //체육복이 없는 학생일 경우
            if(res[i] == 0){
                //맨 첫번째가 아니고 이전 사람이 체육복이 두 개인 경우
                if(i!=0 && res[i-1] == 2){
                    //체육복 없는 학생에게 빌려주고
                    res[i] ++;
                    //빌려준 사람의 체육복 개수 --
                    res[i-1]--;
                }
                //마지막 사람이 아니고 다음 사람이 체육복이 두 개인 경우
                else if(i!=res.length-1 && res[i+1] == 2){
                    //체육복 없는 학생에게 빌려주고
                    res[i] ++;
                    //빌려준 사람의 체육복 개수 --
                    res[i+1] --;
                }
            }
        }

        //체육복이 있는 인원 수 카운트
        for(int i=0;i<res.length;i++)
            if(res[i] !=0)
                answer ++;
        return answer;
    }
}
