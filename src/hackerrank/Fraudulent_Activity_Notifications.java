package hackerrank;

import java.io.IOException;

public class Fraudulent_Activity_Notifications {
    static int MAX_VALUE = 201;
    static int activityNotifications(int[] expenditure, int d) {
        int answer = 0;

        int[] count = new int[MAX_VALUE];

        //우선 d 길이의 배열 정렬을 위해 count 배열에 저장
        for(int i=0;i<d;i++){
            count[expenditure[i]]++;
        }

        for(int i=d; i<expenditure.length; i++){

            //i 인덱스 앞 d 만큼의 수들 중 중간값을 구하고
            double median = findMedian(expenditure, d, count);

            //알람을 보내야하는지 검사
            if(expenditure[i] >= median*2) answer++;

            //맨 앞에꺼를 빼고
            count[expenditure[i-d]]--;
            //현재 값을 count에 저장
            count[expenditure[i]]++;
        }

        return answer;
    }

    private static double findMedian(int[] expenditure, int d, int[] count) {

        int num = 0;
        //d가 홀수면 가운데 값으로
        if(d%2 != 0){
            for(int i=0;i<MAX_VALUE;i++){
                num += count[i];
                if(num > d/2)
                    return i;
            }
        }else{
            int first = 0, second = 0;
            for(int i=0;i<MAX_VALUE;i++){
                num += count[i];

                //first 변수가 비어있고 num이 중간을 넘어섰다면
                if(first == 0 && num >= d/2)
                    first = i;
                //second 변수가 비어있고 num이 중간+1을 넘어섰다면
                if(second == 0 && num >= d/2+1){
                    second = i;
                    return (first+second)/2.0;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        int arr[] = {1,2,3,4,4};
        System.out.println(activityNotifications(arr, 4));
    }
}
