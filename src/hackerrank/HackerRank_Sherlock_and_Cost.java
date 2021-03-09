package hackerrank;

public class HackerRank_Sherlock_and_Cost {
    public static void main(String[] args) {
        int[] arr = {4, 7, 9};
        System.out.println(cost(arr));
    }

    static int cost(int[] B) {

        int[][] dp = new int[B.length][2];

        for(int i=1;i<B.length;i++){
            //'1'을 선택했다면
            //이전 B[i-1]을 선택했을 때의 최대값에 '1'-B[i-1]의 절대값을 더한 것과
            // 이전에 1을 선택했을 때 '1'-1의 절대값을 더한 것 중 큰 값 저장
            dp[i][0] = Math.max(dp[i-1][1] + Math.abs(1-B[i-1]) , dp[i-1][0]);

            //반대로 'B[i]'을 선택했다면
            //이전에 B[i-1]을 선택했을 때의 최대값에 'B[i]'-B[i-1]의 절대값을 더한 것과
            //이전에 1을 선택했을 때 'B[i]'-1의 절대값을 더한 것 중 큰 값 저장
            dp[i][1] = Math.max(dp[i-1][1] + Math.abs(B[i]-B[i-1]), dp[i-1][0] + Math.abs(B[i]-1));
        }

        return Math.max(dp[B.length-1][0], dp[B.length-1][1]);
    }
}
