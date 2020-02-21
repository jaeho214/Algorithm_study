package codility.lesson13;

public class Ladder {

    public static void main(String[] args) {
        Ladder ladder = new Ladder();
        int[] a = {4,4,5,5,1,50000};
        int[] b = {3,2,4,3,1,30};
        System.out.println(ladder.solution(a,b));
    }

    public int[] solution(int[] A, int[] B) {
        int len = A.length;
        int max = 0;
        int[] res = new int[len];
        for(int a : A)
            max = Math.max(max, a);

        int fibonacci[] = fibonacci(max);

        for(int i=0;i<len;i++){
            res[i] = fibonacci[A[i]+1] % (int)Math.pow(2, B[i]);
        }

        return res;
    }


    private int[] fibonacci(int n){
        int dp[] = new int[n+2];

        dp[0] = 0;
        dp[1] = 1;
        for(int i=2;i<=n+1;i++){
            //피보나치 수열이 어마어마하게 커지기 때문에 나머지를 구할 값 중 가장 큰 값인
            //2^30으로 연산을 해주었다.
            dp[i] = (dp[i-1]+ dp[i-2]) % (int)Math.pow(2,30);
        }
        return dp;
    }
}
