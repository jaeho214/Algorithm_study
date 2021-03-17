package leetCode;

import java.util.Arrays;

public class Leetcode_935_Knight_Dialer_DP {
    public static void main(String[] args) {
        Leetcode_935_Knight_Dialer_DP knight_dialer = new Leetcode_935_Knight_Dialer_DP();
        System.out.println(knight_dialer.knightDialer(5));
    }

    private final static int MOD = 1000000007;
    public int knightDialer(int n) {

        int[]dp = new int[10];
        Arrays.fill(dp, 1);

        int answer = 0;
        //0~9까지가 갈 수 있는 다이얼 값 배열
        int[][] dialer = {{4,6}, {6,8}, {7,9}, {4,8}, {0,3,9}, {}, {1,7,0}, {2,6}, {1,3}, {2,4}};

        while(n > 1){
            int[] tmp = new int[10];
            for(int i=0;i<10;i++){
                //0~9까지 다이얼이 갈 수 있는 값을 구하고
                int[] d = dialer[i];
                for(int j : d){
                    //갈 수 있는 다이얼이 또 다른 다이얼을 갈 수 있는 만큼을 더해준다.
                    tmp[i] += dp[j];
                    tmp[i] %= MOD;
                }
            }
            dp = tmp;
            n--;
        }

        for(int d : dp)
            answer = (answer+d) % MOD;

        return answer;
    }
}
