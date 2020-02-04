package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * https://bcp0109.tistory.com/32
 * 플래그를 두개를 써줬어야 했다. 플래그를 하나만 써주고 다 돌아서 시간초과가 났다.
 */
public class BOJ_9466_텀프로젝트 {
    static int t,n, res, arr[];
    static boolean visited[], finished[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            n = Integer.parseInt(br.readLine());
            res = 0;
            arr = new int[n+1];
            finished = new boolean[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=n;j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n+1];
            for(int j=1;j<=n;j++){
                dfs(j);
            }
            System.out.println(n-res);
        }
    }

    private static void dfs(int now) {
        //이미 방문한 노드면 리턴
        if (visited[now])
            return;

        //방문한 노드가 아니면 방문
        visited[now] = true;
        //현재 노드와 연결된 노드 번호를 next에 저장
        int next = arr[now];
        //next 노드가 방문되지 않았으면
        if (!visited[next]) {
            //dfs
            dfs(next);
        //next 가 이미 방문한 노드라면
        } else {
            //이미 연산이 끝난 노드인지 판단
            //아직 연산이 안끝난 노드라면
            if (!finished[next]) {
                //카운트
                res++;
                //연결된 노드들 모두 카운트
                for (int i = next; i != now; i = arr[i])
                    res++;
            }
        }

        //연산이 끝난 노드 true 처리
        finished[now] = true;
    }
}
