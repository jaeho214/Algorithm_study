package programmers.greedy;

import java.util.Arrays;

public class PGMS_체육복_second {

    public static void main(String[] args) {
        PGMS_체육복_second pgms_체육복_second = new PGMS_체육복_second();
        int[] lost = {1};
        int[] reserve = {1};
        System.out.println(pgms_체육복_second.solution(8, lost, reserve));
    }

    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i=0; i<lost.length; i++){
            n--;
            if(Arrays.binarySearch(reserve, lost[i]) >= 0) {
                reserve[Arrays.binarySearch(reserve, lost[i])] = -1;
                lost[i] = -1;
                n++;
            }
        }
        Arrays.sort(reserve);
        for(int los : lost){
            if(los != -1) {
                if(Arrays.binarySearch(reserve, los-1) >= 0) {
                    reserve[Arrays.binarySearch(reserve, los-1)] = -1;
                    n++;
                }else if(Arrays.binarySearch(reserve, los+1) >= 0) {
                    reserve[Arrays.binarySearch(reserve, los+1)] = -1;
                    n++;
                }

            }

        }
        return n;
    }

}
