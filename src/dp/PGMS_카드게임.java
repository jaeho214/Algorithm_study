package dp;

import java.util.Arrays;

/*
 * https://webfirewood.tistory.com/92
 */
public class PGMS_카드게임 {
    public static void main(String[] args) {
        PGMS_카드게임 pgms_카드게임 = new PGMS_카드게임();
        int[] left = {3,2,5};
        int[] right = {2,4,1};
        System.out.println(pgms_카드게임.solution(left, right));
    }

    public int solution(int[] left, int[] right) {
        int answer = 0;
        //dp[i][j] = 왼쪽 카드 i번째, 오른쪽 카드 j번째까지의 최대 점수
        int[][] dp = new int[left.length+1][right.length+1];

        //이미 카드를 뺀 경우를 확인하기 위해 -1로 초기화
        //-1이면 뺀 경우를 확인하지 않은 것
        for(int i=0;i<=left.length; i++) {
            for (int j = 0; j <= right.length; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;

        for(int i=0;i<left.length;i++){
            for(int j=0;j<right.length;j++){
                if(dp[i][j] == -1)
                    continue;
                //왼쪽 카드의 수가 오른쪽 카드보다 크면
                if(left[i] > right[j]){
                    //오른쪽 카드를 빼고난 후의 결과에 현재 점수 + 오른쪽 카드 점수
                    dp[i][j+1] = Math.max(dp[i][j] + right[j], dp[i][j+1]);
                // 오른쪽 카드가 더 크거나 같으면
                }else{
                    //둘다 뺀 결과에 현재결과와 왼쪽 카드를 뺀 결과중 큰 값을 넣고
                    dp[i+1][j+1] = Math.max(dp[i][j], dp[i+1][j]);
                    //왼쪽만 뺀 결과에 현재 결과를 넣는다.
                    dp[i+1][j] = dp[i][j];
                }
            }
        }

        for(int i=0;i<=left.length;i++){
            for(int j=0;j<=right.length;j++){
                answer = Math.max(answer, dp[i][j]);
            }
        }

        return answer;
    }
}
