package codility.lesson6;

import javafx.scene.control.Alert;

import java.util.Arrays;

public class Triangle {

    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        int[] arr = {1,1,2,3,5};
        System.out.println(triangle.solution(arr));
    }

    public int solution(int[] A) {
        long[] a = new long[A.length];
        for(int i=0;i<A.length;i++){
            a[i] = A[i];
        }
        Arrays.sort(a);

        for(int i=a.length-1;i>=2;i--){
            if(a[i] >= a[i-1] + a[i-2])
                continue;
            return 1;
        }

        return 0;

    }
}
