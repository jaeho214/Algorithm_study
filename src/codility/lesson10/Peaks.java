package codility.lesson10;

import java.util.ArrayList;
import java.util.List;
/*
 * 최대값을 구하면 되는데 왜 자꾸 작은 값부터 계산했는지 모르겠다,,,
 * time error 때문에 2시간동안 고생했다,,
 */
public class Peaks {

    public static void main(String[] args) {
        Peaks peaks = new Peaks();
        int[] a = {1,2,3,4,3,4,1,2,3,4,6,2};
        System.out.println(peaks.solution(a));
    }

    public int solution(int[] A) {
        int len = A.length;

        if(len < 3)
            return 0;

        List<Integer> peakList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<A.length-1;i++){
            if(A[i-1] < A[i] && A[i] > A[i+1]){
                peakList.add(i);
            }
        }

        if(peakList.size() == 0)
            return 0;

        //큰 수부터 list에 넣기
        for(int i=peakList.size();i>=1;i--){
            if(len % i == 0){
                list.add(i);
            }
        }

        for(int i : list){
            int idx = 0;
            int num = len/i;
            for(int peak : peakList) {
                if (idx * num <= peak && peak < (idx + 1) * num) {
                    idx++;
                }
            }
            //큰 수부터 하므로 바로 리턴해줄 수 있다.
            if (idx == i) {
                return idx;
            }
        }

        return 1;

    }
}
