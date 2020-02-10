package codility.lesson5;
/*
 * https://wildcatsy.blogspot.com/2017/04/codility-lesson-5-frefix-sums_25.html
 * 수학적인 지식이 좀 필요했다.
 * 알고리즘은 이해하기 쉬웠으나 왜 그렇게 되는지는 이해하기 힘들었다.
 */
public class MinAvgTwoSlice {

    public static void main(String[] args) {
        MinAvgTwoSlice minAvgTwoSlice = new MinAvgTwoSlice();
        int[] arr = {4,2,2,5,1,5,8};
        System.out.println(minAvgTwoSlice.solution(arr));
    }

    public int solution(int[] A) {
        float min = Float.MAX_VALUE;
        int res = 0;
        for(int i=0;i<A.length;i++){
            if(i+1 < A.length){
                if(min > (A[i] + A[i+1])/2f){
                    min = (A[i] + A[i+1])/2f;
                    res = i;
                }
            }
            if(i+2 < A.length){
                if(min > (A[i] + A[i+1] + A[i+2])/3f){
                    min = (A[i] + A[i+1] + A[i+2])/3f;
                    res = i;
                }
            }
        }
        return res;
    }
}
