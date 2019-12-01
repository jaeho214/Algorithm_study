package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_6603_로또 {
    private static int k,cnt;
    private static int s[];
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(!br.readLine().equals("0")){
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            s = new int[k+1];
            for(int i=1;i<=k;i++){
                s[i] = Integer.parseInt(st.nextToken());
            }
            for(int i=1;i<=k;i++){
                cnt = 1;
                dfs(i, s[i] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void dfs(int v, String str) {
        if (cnt == 6) {
            sb.append(str + "\n");
        } else {
            for (int i = v + 1; i <= k; i++) {
                ++cnt;
                dfs(i, str + s[i] + " ");
            }
        }
        --cnt;
    }
}
