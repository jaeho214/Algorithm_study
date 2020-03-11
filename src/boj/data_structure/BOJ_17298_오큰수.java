package boj.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17298_오큰수 {
    public static void main(String arg[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            int num = Integer.valueOf(st.nextToken());
            list.add(num);
        }

        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                result.add(-1);
                stack.push(list.get(i));
                continue;
            }
            else {
                while (!stack.isEmpty()) {
                    int num = stack.pop();
                    if (list.get(i) < num) {
                        result.add(num);
                        stack.push(num);
                        stack.push(list.get(i));
                        break;
                    } else {
                        if (stack.isEmpty()) {
                            result.add(-1);
                            break;
                        }
                    }
                }
                stack.push(list.get(i));
            }


        }
        for(int i=n-1;i>=0;i--){
            System.out.print(result.get(i) + " ");
        }

    }
}