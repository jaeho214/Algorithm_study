package programmers.level1;

public class Level1_소수찾기 {
    public static void main(String[] args) {
        Level1_소수찾기 level1_소수찾기 = new Level1_소수찾기();
        System.out.println(level1_소수찾기.solution(13));
    }

    public int solution(int n) {
        int cnt = 0;
        for(int i=1;i<=n;i++){
            cnt += isPrime(i);
        }
        return cnt;
    }
    private int isPrime(int n){
        if(n == 1)
            return 0;

        if(n % 2 ==0)
            return n==2? 1: 0;

        for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n % i ==0)
                return 0;
        }
        return 1;
    }
}
