package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_2217_로프_second {
    public static void main(String[] args) {
        int[] arr = input();

        Arrays.sort(arr);
        int max = Integer.MIN_VALUE;
        for(int i = arr.length-1; i>=0; i--){
            max = Math.max((arr.length-i) * arr[i], max);
        }
        System.out.println(max);
    }

    public static int[] input(){
        int arr[] = {};
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            arr = new int[t];
            for(int i=0;i<t;i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
