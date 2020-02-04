package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * n : 동전의 개수
 * k : 금액
 * coin : 동전들의 종류가 담긴 배열
 * 동전을 최소한으로 사용해서 해당 금액을 만들기
 */
public class BOJ_11047_동전0 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coin[] = new int[n];

        for(int i=0;i<n;i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int j=coin.length-1;j>=0;j--) {
            if(k>=coin[j]) {
                count += k / coin[j];
                k %= coin[j];
            }
        }

        System.out.print(count);
    }
}
