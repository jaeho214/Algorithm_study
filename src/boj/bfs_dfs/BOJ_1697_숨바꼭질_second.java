package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_1697_숨바꼭질_second {
    static int subin;
    static int sister;
    static int result;
    static int[] d = {-1, 1, 2};
    public static void main(String[] args) throws Exception {
        input();
        solve();
        output();
    }

    private static void solve() {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        int[] arr = new int[100001];
        q.add(subin);

        while(!q.isEmpty()){
            int poll = q.poll();
            if(poll == sister)
                break;
            for(int i=0;i<3;i++){
                int next = 0;
                if(i==2){
                    next = poll*d[i];
                }else{
                    next = poll+d[i];
                }

                if(next < 0 || next > 100000)
                    continue;
                if(visited[next])
                    continue;

                arr[next] = arr[poll]+1;
                visited[next] = true;
                q.add(next);
            }
        }

        result = arr[sister];
    }

    private static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        subin = Integer.parseInt(str[0]);
        sister = Integer.parseInt(str[1]);

        br.close();
    }

    private static void output() throws Exception {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }
}
