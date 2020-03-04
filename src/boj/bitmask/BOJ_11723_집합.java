package boj.bitmask;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        int num = 0;
        for(int i = 0; i < t;i++){
            st = new StringTokenizer(br.readLine());
            String sign = st.nextToken();
            int number = 0;
            if(st.hasMoreTokens())
                number = Integer.parseInt(st.nextToken());
            switch (sign){
                case "add":
                    num |= (1<<number);
                    break;
                case "remove":
                    num &= ~(1<<number);
                    break;
                case "check":
                    bw.write((num & (1<<number)) == (1<<number) ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num ^= (1<<number);
                    break;
                case "all":
                    num = (1<<21) -1;
                    break;
                case "empty":
                    num = 0;
                    break;
            }
        }
        bw.flush();
    }
}
