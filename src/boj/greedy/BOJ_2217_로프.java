package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * N : 로프의 개수
 * w : 로프들이 들 수 있는 중량들의 배열
 * 로프들이 들 수 있는 최대 중량을 구하라(단, 모든 로프를 사용할 필요는 없음)
 */
public class BOJ_2217_로프 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int w[] = new int[N];
        int num = N, max = 0;
        for(int i=0;i<N;i++) {
            w[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(w);
        max = w[0]*num;

        for(int i=0;i<N;i++) {
            if((w[i]*num) > max) {
                max = w[i]*num;
            }
            num--;
        }

        System.out.println(max);
    }

}
