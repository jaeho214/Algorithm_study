package boj.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_6359_만취한상범 {
    static boolean open[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            int n = Integer.parseInt(br.readLine());
            open = new boolean[n+1];
            System.out.println(solve(n));
        }
    }

    private static int solve(int n) {
        for(int i=1;i<=n;i++)
            open[i] = false;

        //라운드 별로 방문을 열고 닫음
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(j % i == 0)
                    open[j] = !open[j];
            }
        }

        //최종적으로 열려있는 방문 개수 체크
        int result = 0;
        for(int i=1;i<=n;i++){
            if(open[i])
                result++;
        }

        return result;
    }
}
