package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Max_Min {

    public static void main(String[] args) {
        int[] arr = {4504,
                1520,
                5857,
                4094,
                4157,
                3902,
                822,
                6643,
                2422,
                7288,
                8245,
                9948,
                2822,
                1784,
                7802,
                3142,
                9739,
                5629,
                5413,
                7232};
        System.out.println(maxMin(5, arr));
    }

    static int maxMin(int k, int[] arr) {

        int answer = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for(int i=0;i<arr.length-k+1;i++){
            answer = Math.min(answer, arr[i+k-1]-arr[i]);
        }

        return answer;
    }
}
