package boj.dp;

import java.io.*;
import java.util.StringTokenizer;
/*
 * 평범한 print 문으로 하니까 시간초과 엄청 났다.. BufferedWriter로 해결
 */
public class BOJ_10942_팰린드롬 {
    private static int num[];
    private static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        num = new int[n+1];
        for(int i=1;i<=n;i++)
            num[i] = Integer.parseInt(st.nextToken());

        dp = new boolean[n+1][n+1];
        for(int i=1;i<=n;i++){
            //i~i는 무조건 가능
            dp[i][i] = true;
            //i-1 과 i가 같으면 가능
            if(num[i-1] == num[i])
                dp[i-1][i] = true;
        }
        for(int i=2; i<n; i++){
            for(int j=1; j<=n-i; j++){
                //양쪽 끝이 같고 그 중간이 True 면 팰린드롬 만족
                if(num[j] == num[j+i] && dp[j+1][j+i-1])
                    dp[j][j+i] = true;
            }
        }

        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st1.nextToken());
            int e = Integer.parseInt(st1.nextToken());
            //시간초과 났던 문제의 구간
            if(dp[s][e]) {
                bw.write("1\n");
            }else{
                bw.write("0\n");
            }
            bw.flush();
        }
        bw.close();
        br.close();
    }
}
