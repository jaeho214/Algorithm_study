package programmers.dp;

/*
 * https://doohong.github.io/2019/03/14/Algorithm-%20thievery/
 * 둥글게 되어있다는 점을 못보고 게속 잘못 풀었다..
 * 첫번째 집을 터는 경우와 털지 않는 경우로 나눠서 풀 생각을 못했다..
 */
public class PGMS_도둑질 {
    public static void main(String[] args) {
        int[] money = {1,2,3,1};
        PGMS_도둑질 pgms_도둑질 = new PGMS_도둑질();
        System.out.println(pgms_도둑질.solution(money));
    }

    public int solution(int[] money) {
        //첫번째 집을 터는 경우 마지막 집을 털 수 없음
        int[] dp = new int[money.length-1];
        //두번째 집부터 터는 경우
        int[] dp2 = new int[money.length];

        //첫번째 집을 털면 money[0] 을 털게 됨
        dp[0] = money[0];
        //두번째 집을 털 수 없으므로 money[0] 그대로
        dp[1] = money[0];
        //첫번째 집을 털지 않고
        dp2[0] = 0;
        //두번째 집부터 털게 됨
        dp2[1] = money[1];

        for(int i=2;i<money.length-1;i++){
            dp[i] = Math.max(dp[i-2] + money[i], dp[i-1]);
        }

        for(int i=2;i<money.length;i++){
            dp2[i] = Math.max(dp2[i-2] + money[i], dp2[i-1]);
        }

        return Math.max(dp[money.length-2], dp2[money.length-1]);


    }
}
