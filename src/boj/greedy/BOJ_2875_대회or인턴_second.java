package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2875_대회or인턴_second {
    public static void main(String[] args) {
        int arr[] = input();
        int m = arr[0];
        int n = arr[1];
        int k = arr[2];

        int res = 0;
        while(true){
            m -= 2;
            n --;
            if(m+n < k || n<0 || m<0)
                break;
            res ++;
        }
        System.out.println(res);
    }

    public static int[] input(){
        int arr[] = new int[3];
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i=0;i<3;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
