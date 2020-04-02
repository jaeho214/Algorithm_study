package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1080_행렬_second {
    static int[][] source;
    static int[][] destination;
    static int m,n;
    public static void main(String[] args) throws IOException {
        input();
        int cnt = 0;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length; j++) {
                if(source[i][j] != destination[i][j]) {
                    if (compare(source, i, j))
                        cnt++;
                    else {
                        System.out.println("-1");
                        return;
                    }
                }
            }
        }
        System.out.println(cnt);
    }

    private static boolean compare(int[][] source, int x, int y) {
        //오른쪽에서 세번째꺼가 같은데 오른쪽에서 두 개가 다르면
        // 아무리 바꿔도 불가능함
        if(x+3>n || y+3>m)
            return false;

        for(int i=x;i<=x+2;i++) {
            for(int j=y;j<=y+2;j++) {
                source[i][j]= 1 - source[i][j];
            }
        }
        return true;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        source = new int[n][m];
        destination = new int[n][m];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                source[i][j] = str.charAt(j) -'0';
            }
        }
        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<str.length();j++){
                destination[i][j] = str.charAt(j) -'0';
            }
        }
    }
}
