package programmers.level2;

public class Level2_점프와순간이동 {
    public static void main(String[] args) {
        Level2_점프와순간이동 level2_점프와순간이동 = new Level2_점프와순간이동();
        System.out.println(level2_점프와순간이동.solution(5000));
    }
    public int solution(int n) {
        int ans = 0;

        while(n > 0){
            ans += n%2;
            n /= 2;
        }

        return ans;

        //효율성에서 실패한 코드드
//       int dp[] = new int[n+1];
//
//        dp[0] = 0;
//        dp[1] = 1;
//        for(int i=2;i<=n;i++){
//            if(i%2 ==0)
//                dp[i] = Math.min(dp[i/2], dp[i-1]+1);
//            else
//                dp[i] = dp[i-1]+1;
//        }
//
//        return dp[n];
    }
}
