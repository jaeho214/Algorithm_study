package search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PGMS_소수찾기 {
    public static void main(String[] args) {
        PGMS_소수찾기 pgms_소수찾기 = new PGMS_소수찾기();
        System.out.println(pgms_소수찾기.solution("011"));
    }

    public int solution(String numbers) {
        Integer[] num = new Integer[numbers.length()];
        int cnt[] = new int[10];
        for(int i=0;i<numbers.length();i++) {
            num[i] = numbers.charAt(i) - '0';
            cnt[num[i]]++;
        }

        Arrays.sort(num, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(Integer i : num)
            sb.append(i);
        int max = Integer.parseInt(sb.toString());
        int min = Arrays.stream(num).mapToInt(i -> i.intValue()).min().getAsInt();

        if(min < 2)
            min = 2;

        List<Integer> list = new ArrayList<>();

        for(int i=min; i<=max; i++){
            boolean isPrime = true;
            //종이로 만들 수 있는 숫자인지 파악한 후
            if(!isPossible(String.valueOf(i), cnt)){
                isPrime = false;
            }
            //소수인지 확인하여 소수이면 list에 add
            for(int j=2;j*j<=i;j++){
                if(i%j==0){
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                list.add(i);
            }
        }
        return list.size();
    }

    //숫자들을 카운드하는 배열을 만들어주고
    //숫자가 배열의 개수를 넘어가거나 배열의 개수가 0개이면(즉 종이에 적힌 숫자로 만들 수 없는 숫자이면)
    //false를 리턴
    private boolean isPossible(String number, int[] cnt){
        int[] arr = new int[10];
        for(int i=0;i<number.length();i++){
            int num = number.charAt(i) - '0';
            if(cnt[num] ==0)
                return false;
            arr[num]++;
            if(cnt[num] < arr[num])
                return false;
        }
        return true;
    }
}
