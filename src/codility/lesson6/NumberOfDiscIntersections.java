package codility.lesson6;

import java.util.Arrays;
/*
 * https://jobjava00.github.io/algorithm/codility/lesson6/NumberOfDiscIntersections/
 * 시간초과를 줄이지 못하여서 결국 찾아봤다..
 */
public class NumberOfDiscIntersections {
    public static void main(String[] args) {
        int[] arr = {1,5,2,1,4,0};
        NumberOfDiscIntersections numberOfDiscIntersections = new NumberOfDiscIntersections();
        System.out.println(numberOfDiscIntersections.solution(arr));
    }

    public int solution(int[] A) {
        int len = A.length;
        long[] start = new long[len];
        long[] end = new long[len];

        for(int i=0;i<len;i++){
            start[i] = i - (long) A[i];
            end[i] = i + (long) A[i];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int cnt = 0, j=0;
        for(int i=0;i<len;i++){
            //이 부분을 이해하지 못하겠다,,
            while(j<len && end[i] >= start[j]){
                cnt += j;
                //중복을 막기위해 실행한다는데 모르겠다
                cnt -= i;
                j++;
            }
        }

        if(cnt>10000000)
            return -1;
        return cnt;
    }
}
