package boj.dp;

import java.io.*;

public class BOJ_2163_초콜릿자르기_second {
    static int w,h;
    public static void main(String[] args) throws IOException {
        input();
        output(solve());
    }

    private static int solve() {
        return (w-1) + ((h-1) * w);
    }


    private static void output(int result) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        w = Integer.parseInt(str[0]);
        h = Integer.parseInt(str[1]);
    }
}
