package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
 * https://ghkvud2.tistory.com/12
 */
public class BOJ_11559_PuyoPuyo {
    static class Pair{
        int x,y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int dx[] = {1,0,-1,0};
    static int dy[] = {0,-1,0,1};
    static char arr[][];
    static boolean visited[][];
    static LinkedList<Pair> list = new LinkedList<>();
    static int res=0;

    public static void main(String[] args) throws IOException {
        input();
        solve();
        System.out.println(res);
    }

    private static void solve() {
        //몇연타인지 알기 위해 무한 루프
        while(true){
            boolean flag = true;
            visited = new boolean[13][7];


            for(int i=1;i<=12;i++){
                for(int j=1;j<=6;j++){
                    //뿌요가 있는 곳을 bfs로 탐색한 후
                    if(!visited[i][j] && arr[i][j] != '.')
                        bfs(i,j);

                    //그 색깔이 4개 이상 붙어있으면
                    if(list.size()>=4){
                        //플래그를 끄고
                        flag = false;
                        //그 뿌요들을 터트림('.'로 바꿈)
                        for(Pair pair : list){
                            arr[pair.x][pair.y] = '.';
                        }
                    }
                    //다음 bfs를 위해 리스트를 비워줌
                    list.clear();
                }
            }
            //한 회의 뿌요가 끝나면 중력에 의해 모든 뿌요들이 밑으로 내려감
            toGround();
            if(flag)
                break;
            else
                res += 1;
        }
    }

    private static void toGround() {

        for(int i=1;i<=6;i++){
            //맨 밑에서부터
            for(int j=12;j>=1;j--){
                //그 자리가 빈칸일 때
                if(arr[j][i] == '.'){
                    //밑에서부터 쭉 올라가다가
                    for(int k=j;k>=1;k--){
                        //뿌요가 있으면
                        if(arr[k][i] != '.'){
                            //그 뿌요를 빈칸인 곳에 넣어주고
                            arr[j][i] = arr[k][i];
                            //원래 뿌요가 있던 자리를 빈 공간으로 해줌
                            arr[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void bfs(int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x,y));
        while(!q.isEmpty()){
            Pair pair = q.poll();
            visited[pair.x][pair.y] = true;
            list.add(pair);
            for(int i=0;i<4;i++){
                int nx = pair.x + dx[i];
                int ny = pair.y + dy[i];
                if(nx>=1 && nx<=12 && ny>=1 && ny<=6) {
                    if (arr[pair.x][pair.y] == arr[nx][ny] && !visited[nx][ny]){
                        q.add(new Pair(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[13][7];
        visited = new boolean[13][7];
        for(int i=1;i<=12;i++){
            String str = br.readLine();
            for(int j=1;j<=6;j++){
                arr[i][j] = str.charAt(j-1);
            }
        }
        br.close();
    }
}
