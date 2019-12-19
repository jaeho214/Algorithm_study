package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9019_DSLR {
    static int t,a,b;
    static boolean visited[];
    static String res[];
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            q = new LinkedList<>();
            visited = new boolean[10001];
            res = new String[10001];
            Arrays.fill(res, "");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            bfs();
            System.out.println(res[b]);
        }
    }

    private static void bfs() {
        q.add(a);
        while(!q.isEmpty()){
            a = q.poll();
            visited[a] = true;
            int num1 = D(a);
            int num2 = S(a);
            int num3 = L(a);
            int num4 = R(a);
            if(!visited[num1]){
                q.add(num1);
                visited[num1] = true;
                res[num1] = res[a] + 'D';
            }
            if(!visited[num2]){
                q.add(num2);
                visited[num2] = true;
                res[num2] = res[a] + 'S';
            }
            if(!visited[num3]){
                q.add(num3);
                visited[num3] = true;
                res[num3] = res[a] + 'L';
            }
            if(!visited[num4]){
                q.add(num4);
                visited[num4] = true;
                res[num4] = res[a] + 'R';
            }
            if(num1 == b || num2 == b || num3 == b || num4 == b )
                return;

        }
    }

    private static int L(int a) {
        return (a/1000) + ((a%1000)*10);
    }

    private static int R(int a) {
        return ((a%10)*1000) + (a/10);
    }

    private static int S(int a) {
        if(a == 0)
            return 9999;
        else
            return a-1;
    }

    private static int D(int a) {
        if(a * 2 > 9999)
            return (2*a) % 10000;
        else
            return a*2;
    }

}
