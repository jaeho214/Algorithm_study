package sort;

import java.util.Arrays;

public class PGMS_가장큰수 {

    public static void main(String[] args) {
        int[] numbers = {0,0,0,0};
        PGMS_가장큰수 pgms_가장큰수 = new PGMS_가장큰수();
        System.out.println(pgms_가장큰수.solution(numbers));
    }


    public String solution(int[] numbers) {
        String answer = "";
        Integer arr[] = new Integer[numbers.length];
        int cnt=0;
        for(int i=0;i<numbers.length;i++) {
            if(numbers[i] == 0)
                cnt++;
            arr[i] = numbers[i];
        }
        //모두 0일 경우 000이 아니라 0으로 출력되게끔
        if(cnt == answer.length())
            return "0";


        Arrays.sort(arr, (o1, o2) -> {
            //첫번째 자리 수가 큰거 순으로 나열해야되기 때문에 String 으로 해줘야겠다고 판단
            String first = String.valueOf(o1);
            String second = String.valueOf(o2);
            //두 수를 이어 붙였을 때 큰거 순으로 나열할 수 있도록
            return (second+first).compareTo(first+second);
        });

        for(Integer i : arr){
            answer += String.valueOf(i);
        }



        return answer;
    }
}
