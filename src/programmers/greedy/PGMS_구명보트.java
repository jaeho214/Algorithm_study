package programmers.greedy;

import java.util.Arrays;
/*
 * https://aig2029.tistory.com/127
 * 최소 + 최대 로 푸는 건 알았는데 구현을 못했다,,
 */
public class PGMS_구명보트 {
    public static void main(String[] args) {
        int[] people = {70,80,50};
        System.out.println(solution(people, 100)) ;
    }


    public static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);

        int start=0, end;
        for(end=people.length-1; start<end ; end--){
            //최소+최대가 limit 보다 크면 최대만 카운트
            if(people[start] + people[end] > limit)
                answer++;
            //최소 + 최대가 limit보다 작으면
            else{
                //카운트하고
                answer ++;
                //최소값 인덱스 ++
                start++;
            }
        }
        //하나 남으면
        if(start==end)
            //카운트
            answer++;

        return answer;
    }
}

