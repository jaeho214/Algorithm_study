package boj.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * http://joonas-yoon.blogspot.com/2016/03/2718.html
 */
public class BOJ_2718_타일채우기 {
    //dp[n][bit] = n번째에서 bit만큼 차있는 경우의 수
    static int dp[][];
    static int num;
    public static void main(String[] args) throws IOException {
        input();
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0;i<t;i++){
            num = Integer.parseInt(br.readLine());
            dp = new int[num+1][16];
            System.out.println(solution(num, 0));
        }
    }

    private static int solution(int num, int bit) {
        if(num < 0) return 0;
        if(num < 1) return bit == 0? 1 : 0;

        if(dp[num][bit] > 0)
            return dp[num][bit];

        if(bit ==0){
            dp[num][bit]+= solution(num-1, 9);
            dp[num][bit]+= solution(num-1, 12);
            dp[num][bit]+= solution(num-2, 0);
            dp[num][bit]+= solution(num-1, 3);
            dp[num][bit]+= solution(num-1, 0);
        }
        //이미 3비트만큼 차있는 경우
        if(bit == 3){
            //n-1에서 다 비어있는 경우와
            dp[num][bit] += solution(num-1, 0);
            //n-1에서 12비트만큼 차있는 경우를 합하면 된다. 다른 것들도 마찬가지
            dp[num][bit] += solution(num-1, 12);
        }
        if(bit == 6){
            dp[num][bit] += solution(num-1, 9);
        }
        if(bit == 9){
            dp[num][bit] += solution(num-1, 0);
            dp[num][bit] += solution(num-1, 6);
        }
        if(bit == 12){
            dp[num][bit] += solution(num-1, 0);
            dp[num][bit] += solution(num-1, 3);
        }

        return dp[num][bit];
    }
}
