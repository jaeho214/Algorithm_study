package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1679_숨바꼭질 {
    private static int n, k;
    private static boolean visited[];
    //bfs로 하되 배열에 거리를 저장하면서 진행함
    private static int road[];
    public static void main(String[] args) {
        input();
        System.out.println(solve());
    }

    private static int solve() {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        int a=0;
        while(!q.isEmpty()){
            a = q.poll();
            int array[] = {1,-1, a};
            visited[a] = true;

            for(int i=0;i<3;i++){
                int next = a + array[i];
                //10만으로 해줬어야 했는데 10만1로 범위 설정 잘못해서 런타임 에러
                if(next >= 0 && next <= 100000){
                    if(next != k && !visited[next]){
                        q.add(next);
                        visited[next] = true;
                        road[next] = road[a]+1;
                    }
                    else if(next == k && !visited[next]){
                        road[next] = road[a]+1;
                        q.clear();
                        break;
                    }
                }
            }
        }
        return road[k];
    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            visited = new boolean[100001];
            road = new int[100001];
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
