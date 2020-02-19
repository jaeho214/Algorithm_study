package codility.lesson11;
/*
 * https://github.com/ZRonchy/Codility/blob/master/Lesson9/CountSemiprimes.java
 */
public class CountSemiPrimes {
    public static void main(String[] args) {
        CountSemiPrimes countSemiprimes = new CountSemiPrimes();
        int []p = {1,4,16};
        int []q = {26,10,20};
        System.out.println(countSemiprimes.solution(26, p, q));
    }

    public int[] solution(int N, int[] P, int[] Q) {
        int length = P.length;
        int[] prime = prime(N);
        int[] semiPrime = semiPrime(prime);
        int[] result = new int[length];
        int[] arr = new int[N+1];

        for(int i=1;i<N+1;i++) {
            arr[i] = semiPrime[i];
            arr[i] += arr[i-1];
        }

        for(int i=0;i<length;i++) {
            int q = Q[i];
            int p = P[i];
            result[i] = arr[q] - arr[p] + semiPrime[p];
        }
        return result;
    }

    //소수를 찾고 그 소수의 배수들을 체크
    public int[] prime(int N) {
        int[] prime = new int[N+1];
        for(int i=2; i<=(double)Math.sqrt(N); i++) {
            if(prime[i] == 0) {
                int k = i*i;
                while(k <= N) {
                    if(prime[k] == 0){
                        prime[k] = i;
                    }
                    k += i;
                }
            }
        }
        return prime;
    }

    //semiPrime을 찾는 메소드
    public int[] semiPrime(int[] prime) {
        int semiPrime[] = new int[prime.length];
        for(int i=0;i<prime.length;i++) {
            //소수의 배수가 아니면 continue
            if(prime[i] == 0) continue;
            //semiPrime이면 배열에 체크
            int firstFactor = prime[i];
            if(prime[i/firstFactor] == 0) semiPrime[i]=1;
        }
        return semiPrime;
    }
}
