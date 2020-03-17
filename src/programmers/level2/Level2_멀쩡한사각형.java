package programmers.level2;
/*
 * https://taesan94.tistory.com/55
 */
public class Level2_멀쩡한사각형 {
    public static void main(String[] args) {
        Level2_멀쩡한사각형 level2_멀쩡한사각형 = new Level2_멀쩡한사각형();
        System.out.println(level2_멀쩡한사각형.solution(100000000,100000000));
    }
    public long solution(int w, int h) {
        long width = Long.parseLong(String.valueOf(w));
        long height = Long.parseLong(String.valueOf(h));

        return (width * height) - (width+height-gcd(w,h));
    }

    public int gcd(int a, int b){
        if(a % b == 0)
            return b;
        return gcd(b, a%b);
    }
}
