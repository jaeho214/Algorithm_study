package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * 3칸짜린데 문제 잘못읽어서 오래걸렸다,, 바부,,
 */
public class BOJ_2096_내려가기 {
    private static int max[][], min[][];
    public static void main(String[] args) throws IOException {
        int n = input();
        solve(n);
        output(max(n), min(n));
    }

    private static void solve(int n) {
        for (int i = 2; i <= n; i++) {
            //0일땐 바로 위와 바로위 오른쪽꺼 가능
            max[i][0] += Math.max(max[i - 1][0], max[i - 1][1]);
            //1일때 위에 세개 다 가능
            max[i][1] += Math.max(max[i - 1][0], Math.max(max[i - 1][1], max[i - 1][2]));
            //2일땐 바로 위와 바로위 왼쪽꺼 가능
            max[i][2] += Math.max(max[i - 1][1], max[i - 1][2]);

            min[i][0] += Math.min(min[i - 1][0], min[i - 1][1]);
            min[i][1] += Math.min(min[i - 1][0], Math.min(min[i - 1][1], min[i - 1][2]));
            min[i][2] += Math.min(min[i - 1][1], min[i - 1][2]);
        }
    }

    private static int min(int n) {
        int res = min[n][0];
        for(byte i=0;i<3;i++)
            res = Math.min(res, min[n][i]);

        return res;
    }

    private static int max(int n) {
        int res = max[n][0];
        for(byte i=0;i<3;i++)
            res = Math.max(res, max[n][i]);

        return res;
    }

    private static int input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        max = new int[n+1][3];
        min = new int[n+1][3];
        for(int i=1;i<=n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                max[i][j] = Integer.parseInt(st.nextToken());
                min[i][j] = max[i][j];
            }
        }
        br.close();
        return n;
    }

    private static void output(int max, int min) {
        System.out.println(max + " " + min);
    }
}
