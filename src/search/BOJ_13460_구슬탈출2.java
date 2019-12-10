package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * http://blog.naver.com/PostView.nhn?blogId=suntouch&logNo=221604734962&parentCategoryNo=&categoryNo=&viewDate=&isShowPopularPosts=false&from=postView
 */
public class BOJ_13460_구슬탈출2 {

    private static int dx[] = {1,0,-1,0};
    private static int dy[] = {0,1,0,-1};
    private static int n,m;
    static char arr[][];
    static boolean redFlag = false;
    static boolean blueFlag = false;
    static boolean endFlag = false;
    static int result = 10;

    public static void main(String[] args) {
        input();
        //arr배열을 가지고 10부터 내림차순으로 카운트
        dfs(arr, 10);

        //endFlag가 켜져있지 않으면 불가능으로 간주
        if(!endFlag)
            result = -1;

        System.out.println(result);
    }

    private static void dfs(char[][] arr, int cnt) {
        //파란구슬이 구멍으로 들어간 경우
        if(blueFlag){
            redFlag = false;
            blueFlag = false;
            //그냥 리턴
            return;
        //빨간구슬이 구멍으로 들어간 경우
        }else if(redFlag){
            endFlag = true;
            redFlag = false;
            //현재 cnt를 보고 10번 중에 몇번을 굴렸는지(10-cnt)를 리턴
            if(result> (10-cnt))
                result = 10-cnt;
            return;
        }


        //10번 이상 굴리면 그냥 리턴
        if(cnt == 0) return;


        char[][] newArr = new char[n+1][m+1];
        for(int i=0;i<4;i++){
            //복사본을 만들어서 구슬을 네 방향으로 굴려보고
            newArr = tilt(i,arr);
            //카운트를 하며 구슬이 구멍으로 들어갔는지 체크
            dfs(newArr, cnt -1);
        }
    }

    //구슬을 굴리는 메소드
    private static char[][] tilt(int dir, char[][] before){
        int blueX = 0;
        int blueY = 0;
        int redX = 0;
        int redY = 0;
        int newX = 0;
        int newY = 0;

        //파라미터로 들어온 배열을 복사해서 newArr로 사용
        char[][] newArr = new char[n+1][m+1];
        //파란 구슬과 빨간 구슬의 좌표를 각각 저장
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                newArr[i][j] = before[i][j];
                if(newArr[i][j] ==  'B'){
                    blueX = j;
                    blueY = i;
                }
                else if(newArr[i][j] == 'R'){
                    redX = j;
                    redY = i;
                }
            }
        }

        //파란구슬과 빨간 구슬이 붙어있을 경우가 있으므로 두번 돌리기
        //파란구슬빨간구슬 -> 이런식으로 배치되어있을 경우 왼쪽으로 이동해도 빨간구슬은 파란구슬에 막혀서 이동 못하기 때문에 반복
        for(int i=1;i<=2;i++){
            //빨간색의 다음 위치를 newX, newY에 각각 저장
            newX = redX + dx[dir];
            newY = redY + dy[dir];
            //빨간 구슬이 옮겨질 다음 위치가 .이거나 O인 경우
            if(newArr[newY][newX] == '.' || newArr[newY][newX] == 'O'){
                //현재 빨간 구슬의 위치를 .으로 바꿈
                newArr[redY][redX] = '.';
                //끝까지 옮기기 위해 while문 사용
                while(newArr[newY][newX] == '.'){
                    redX = newX;
                    redY = newY;
                    newX = redX + dx[dir];
                    newY = redY + dy[dir];
                }
                //최종적으로 빨간구슬이 이동할 위치가 O인 경우
                if(newArr[newY][newX] == 'O'){
                    //redFlag 를 켜줌
                    redFlag = true;
                }
            }
            //빨간 구슬이 구멍으로 들어가지 않았을 경우
            if(!redFlag)
                //그 자리에 R을 위치시킴
                newArr[redY][redX] = 'R';


            //파란 구슬도 똑같이 반복
            newX = blueX + dx[dir];
            newY = blueY + dy[dir];
            if(newArr[newY][newX] == '.' || newArr[newY][newX] == 'O'){
                newArr[blueY][blueX] = '.';
                while(newArr[newY][newX] == '.'){
                    blueX = newX;
                    blueY = newY;
                    newX = blueX + dx[dir];
                    newY = blueY + dy[dir];
                }
                if(newArr[newY][newX] == 'O'){
                    blueFlag = true;
                }
            }
            if(!blueFlag)
                newArr[blueY][blueX] = 'B';
        }

        return newArr;
    }

    private static void input() {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[n+1][m+1];
            for(int i=1;i<=n;i++){
                String str = br.readLine();
                for(int j=1;j<=m;j++){
                    arr[i][j] = str.charAt(j-1);
                }
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
