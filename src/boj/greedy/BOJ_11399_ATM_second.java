package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11399_ATM_second {
    public static void main(String[] args) {
        int[] arr = input();

        Arrays.sort(arr);

        int num = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            num += arr[i];
            sum += num;
        }
        System.out.println(sum);
    }

    private static int[] input() {
        int arr[] = {};
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[t];
            for(int i=0;i<t;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
