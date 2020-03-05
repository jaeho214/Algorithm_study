package boj.bitmask;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1102_발전소 {
    public static int arr[][];
    //dp[cnt][bit] = 발전소가 cnt 개 켜있는데 bit 값대로 발전소가 켜있을 때의 비용
    public static int dp[][];
    public static int n, sum, minimum, cnt;
    public static void main(String[] args) throws Exception {
        input();
        int result = solution(cnt, sum);
        System.out.println(result ==Integer.MAX_VALUE ? -1 : result);
    }

    private static int solution(int cnt, int offBit) {
        //켜져있는 발전소가 최소 필요 개수를 넘어가면 0 리턴
        if(cnt >= minimum)
            return 0;

        if(dp[cnt][offBit] >= 0)
            return dp[cnt][offBit];

        dp[cnt][offBit] = Integer.MAX_VALUE;
        //켜져 있는 발전소를 찾아서
        for(int i=0;i<n;i++){
            int next_i = 1<<i;
            if ((offBit & next_i) > 0) {
                //꺼져 있는 발전소를 찾고
                for (int j = 0; j < n; j++) {
                    int next_j = 1<<j;
                    if((offBit & next_j) > 0 || i==j)
                        continue;
                    //켜져있는 발전소로 꺼져있는 발전소를 켜는 비용을 계산
                    dp[cnt][offBit] = Math.min(dp[cnt][offBit], solution(cnt+1 ,offBit | next_j) + arr[i][j]);
                }
            }
        }
        return dp[cnt][offBit];
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new int[n+1][1<<16];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<n;i++)
            Arrays.fill(dp[i], -1);

        String str = br.readLine();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == 'Y') {
                //발전기가 돌아가는 발전소 bit on
                sum |= (1<<i);
                //켜져있는 발전소 개수 카운트
                cnt++;
            }
        }
        minimum = Integer.parseInt(br.readLine());
    }
}
