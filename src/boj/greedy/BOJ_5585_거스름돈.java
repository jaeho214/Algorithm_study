package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_5585_거스름돈 {
    public static void main(String[] args) {
        int arr[] = {500,100,50,10,5,1};
        int money = 1000 - input();
        int res = 0;

        for(int i=0;i<arr.length;i++){
            if(money == 0)
                break;
            res += money/arr[i];
            money = money%arr[i];
        }

        System.out.println(res);

    }

    public static int  input(){
        int money = 0;
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            money = Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return money;
    }
}
