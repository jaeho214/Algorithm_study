package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_10610_30_second {
    public static void main(String[] args) {
        String num = input();
        if(!num.contains("0")){
            System.out.println(-1);
            return;
        }
        char[] ch = num.toCharArray();
        Arrays.sort(ch);

        int sum = 0;
        StringBuilder result = new StringBuilder();
        for(int i=ch.length-1;i>=0;i--){
            sum += ch[i]-'0';
            result.append(ch[i]);
        }
        if(sum % 3 == 0)
            System.out.println(result.toString());
        else
            System.out.println(-1);
    }

    public static String input(){
        StringBuilder sb = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            sb.append(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
