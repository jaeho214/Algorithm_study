package codility.lesson9;


public class MaxSliceSum {
    public static void main(String[] args) {
        int[] a = {-3,2,6,4,0};
        MaxSliceSum maxSliceSum = new MaxSliceSum();
        System.out.println(maxSliceSum.solution(a));
    }

    public int solution(int[] A) {
        if(A.length == 1)
            return A[0];

        int res=A[0], max=A[0];

        for(int i=1;i<A.length;i++){
            max = Math.max(A[i], max+A[i]);
            res = Math.max(res, max);
        }

        return res;
    }
}
