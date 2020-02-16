package codility.lesson9;
/*
 * https://sustainable-dev.tistory.com/25?category=811591
 */
public class MaxDoubleSliceSum {

    public static void main(String[] args) {
        MaxDoubleSliceSum maxDoubleSliceSum = new MaxDoubleSliceSum();
        int[] a = {3,2,6,-1,4,5,-1,2};
        System.out.println(maxDoubleSliceSum.solution(a));
    }

    public int solution(int[] A) {
        if(A.length == 3)
            return 0;
        int[] front = new int[A.length];// 앞에서부터의 합
        int[] back = new int[A.length]; // 뒤에서부터의 합

        for(int i=1;i<A.length-1;i++)
            //앞에서 부터의 합을 구한다.
            //X와 Y가 1이 차이가 날 경우 0이므로 0과 비교해준다.
            //front[i] 는 i까지의 최대 부분합
            front[i] = Math.max(0, front[i-1]+A[i]);

        for(int i=A.length-2;i>=1; i--)
            //back[i] 는 i부터의 최대 부분합
            back[i] = Math.max(0, back[i+1] + A[i]);

        int max = Integer.MIN_VALUE;
        for(int i=1;i<A.length-1;i++)
            //i는 Y로 생각하면 된다.
            //Y-1까지의 합과 Y+1부터의 합 중 최대값 찾기
            max = Math.max(max, front[i-1]+back[i+1]);

        return max;
    }
}
