package sort;

import java.util.Arrays;

public class PGMS_H_Index {
    public static void main(String[] args) {
        int[] citations = {22,42};
        PGMS_H_Index pgms_h_index = new PGMS_H_Index();
        System.out.println(pgms_h_index.solution(citations));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);

        int max = Arrays.stream(citations).max().getAsInt();

        long[] arr = new long[max+1];

        for(int i=0;i<=max;i++){
            final int number = i;
            arr[i] = Arrays.stream(citations)
                        .filter(target -> compare(number,target))
                        .count();
        }

        for(int i=max;i>=0;i--){
            if(arr[i] >= i)
                return i;
        }

        return 0;
    }

    public boolean compare(int x, int y){
        return (x <= y) ? true : false;
    }
}
