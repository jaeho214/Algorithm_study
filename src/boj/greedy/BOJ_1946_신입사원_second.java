package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1946_신입사원_second {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][2];
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
            }
            System.out.println(solve(arr));
        }
    }

    private static int solve(int[][] arr){
        int result = arr.length;
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[0] < o2[0])
                return -1;
            else if(o1[0] > o2[0])
                return 1;
            else
                return 0;
        });
        int num = arr[0][1];
        for(int i=1;i<arr.length;i++){
            if(num > arr[i][1]){
                num = arr[i][1];
                continue;
            }
            result--;
        }
        return result;
    }


}
