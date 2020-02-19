package codility.lesson11;
/*
 * https://sustainable-dev.tistory.com/31
 */
public class CountNonDivisible {
    public static void main(String[] args) {
        int[] a = {3,1,2,3,6};
        CountNonDivisible countNonDivisible = new CountNonDivisible();
        System.out.println(countNonDivisible.solution(a));
    }

    public int[] solution(int[] A) {
        int len = A.length;
        int[] arr = new int[(len*2)+1];
        int[] res = new int[len];

        for(int a : A){
            arr[a]++;
        }

        for(int i=0;i<len;i++){
            int cnt = 0;
            for(int j=1;j*j<=A[i];j++){
                if(A[i] % j == 0){
                    cnt += arr[j];

                    if(A[i]/j != j)
                        cnt += arr[A[i] / j];
                }
            }
            res[i] = len - cnt;
        }

        return res;
    }
}
