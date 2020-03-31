package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1049_기타줄_second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] packages = new int[m];
        int[] single = new int[m];
        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            packages[i] = Integer.parseInt(st.nextToken());
            single[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solve(packages, single, n));

    }

    private static int solve(int[] packages, int[] single, int n){
        Arrays.sort(packages);
        Arrays.sort(single);
        int min =  Math.min(((n%6) * single[0]) + ((n/6) * packages[0]), n * single[0]);
        min = Math.min(((n/6)+1) * packages[0], min);

        return min;
    }
}
