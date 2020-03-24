package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1541_잃어버린괄호_second {
    public static void main(String[] args) {
        String str = input();

        String[] strArr = str.split("-");
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<strArr.length;i++) {
            try {
                q.add(Integer.valueOf(strArr[i]));
            } catch (Exception e) {
                String[] plusArr = strArr[i].split("\\+");
                int sum = 0;
                for (int j = 0; j < plusArr.length; j++) {
                    sum += Integer.parseInt(plusArr[j]);
                }
                q.add(sum);
            }
        }
        int res = q.poll();
        while(!q.isEmpty()){
            res -= q.poll();
        }

        System.out.println(res);
    }

    public static String input(){
        String str = "";
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return str;
    }
}
