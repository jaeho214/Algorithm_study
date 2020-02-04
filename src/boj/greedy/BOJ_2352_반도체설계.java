package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2352_반도체설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] port = new int[input];
        for(int i=0;i<input;i++)
            port[i] = Integer.parseInt(st.nextToken());

        System.out.println(lis(port));
    }
    static int lis(int [] a) {
        int [] tailTable = new int[a.length];

        tailTable[0] = a[0];
        int length = 1;

        for(int i=1; i<a.length; i++) {
            if(tailTable[0] > a[i]) {
                tailTable[0] = a[i];
            }
            else if(tailTable[length-1] < a[i]) {
                tailTable[length] = a[i];
                length+=1;
            }
            else {
                int idx = Arrays.binarySearch(tailTable, 0, length, a[i]);
                idx = (idx < 0) ? -idx -1 : idx;
                tailTable[idx] = a[i];
            }
        }
        return length;
    }
}
