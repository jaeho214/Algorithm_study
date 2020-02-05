package codility.lesson3;
/*
 * stream을 쓰면 시간을 잡아먹는 다는 것을 알았다.
 * stream은 코드를 간결하게 하지만 시간이 오래걸린다ㅏ..
 */
public class TapeEquilibrium {

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        int[] a = {3,1,2,4,3};
        System.out.println(tapeEquilibrium.solution(a));
    }

    public int solution(int[] A) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int front = 0;

        for(int i=0;i<A.length;i++)
            sum += A[i];

        for(int i=0;i<A.length-1;i++){
            front += A[i];
            int back = sum - front;
            int res = Math.abs(front-back);
            min = Math.min(res, min);
        }

        return min;
    }
}
