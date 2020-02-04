package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2167_2차원배열의합 {
    static int array[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j=1;j<=m;j++){
                array[i][j] = Integer.parseInt(st2.nextToken());
            }
        }
        int cnt = Integer.parseInt(br.readLine());

        for(int i=1;i<=cnt;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());
            System.out.println(solve(a,b,x,y));
        }
    }
    //(a,b) 부터 (x,y) 까지의 합
    private static int solve(int a, int b, int x, int y) {
        int sum = 0;
        for(int i=a;i<=x;i++){
            for(int j=b;j<=y;j++){
                sum += array[i][j];
            }
        }

        return sum;
    }
}
