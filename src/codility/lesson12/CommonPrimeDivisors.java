package codility.lesson12;
/*
 * 최대공약수 관련 문제였다.
 */
public class CommonPrimeDivisors {

    public static void main(String[] args) {
        int[] a = {15,10,3,10,};
        int[] b = {75,30,5,16};
        CommonPrimeDivisors commonPrimeDivisors = new CommonPrimeDivisors();
        System.out.println(commonPrimeDivisors.solution(a,b));
    }

    public int solution(int[] A, int B[]){
        int len = A.length;
        int cnt = 0;

        for(int i=0;i<len;i++){
            if(hasSamePrimeDiv(A[i], B[i]))
                cnt++;
        }

        return cnt;
    }

    private boolean hasSamePrimeDiv(int a, int b) {
        //먼저 두 수의 최대 공약수를 구해준다
        int gcd = getGcd(a,b);
        int gcdA = 0, gcdB = 0;

        //최대 공약수가 1이 될 때까지 a를 최대공약수로 계속 나누어줌
        while(gcdA != 1){
            //a와 최대공약수의 최대 공약수를 또 구해준다.
            gcdA = getGcd(a,gcd);
            //그 공약수로 a를 나눈다
            a /= gcdA;
        }


        while(gcdB != 1){
            gcdB = getGcd(b,gcd);
            b /= gcdB;
        }

        //최대공약수로 계속 나누었을 때 둘다 1이 되는 경우가 true
        return (a==1 && b==1) ? true : false;
    }

    private int getGcd(int a, int b){
        if(b == 0) return a;
        return getGcd(b, a%b);
    }
}
