package kakao.blind2020;

/*
 * https://dundung.tistory.com/138
 * 머릿 속으로 어느정도 생각을 했으나 결국 구현하지 못했다.
 * 배열을 세배로 만들어주고
 * 키와 자물쇠를 조금씩 겹쳐가면서 비교해주는 생각을 하지 못했다.
 * 카카오 너무 어렵다잉~
 */
public class KAKAO_자물쇠와열쇠 {
    static boolean isOk = false;
    public static void main(String[] args) {
        KAKAO_자물쇠와열쇠 kakao_자물쇠와열쇠 = new KAKAO_자물쇠와열쇠();
        int[][] key = {{0,0,0},{1,0,0}, {0,1,1}};
        int[][] lock = {{1,1,1}, {1,1,0}, {1,0,1}};
        System.out.println(kakao_자물쇠와열쇠.solution(key, lock));
    }

    public boolean solution(int[][] key, int[][] lock) {
        int len = lock.length;

        int[][] copyLock = new int[len*3][len*3];

        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                copyLock[i+len][j+len] = lock[i][j];
            }
        }
        dfs(key,copyLock,0);
        return isOk;
    }

    //4번의 회전을 하기위한 dfs
    private void dfs(int[][] key, int[][] lock, int cnt){
        //열쇠가 맞는지 체크를 하고
        check(key, lock, 0, 0);
        //열쇠가 맞으면 종료
        if(isOk) return;
        //4번 회전을 하면 종료
        if(cnt>=4) return;
        //회전을 하고
        int[][] temp = turnArray(key);
        //다시 dfs
        dfs(temp, lock, cnt+1);

    }

    //key와 lock을 비교하는 메소드
    private void check(int[][] key, int[][] lock, int x, int y) {
        //열쇠가 맞으면 return
        if(isOk) return;
        //y가 lock을 벗어나면
        if(y+key.length>lock.length){
            //y를 다시 0으로 맞춰주고
            y=0;
            //세로로 한칸 내려감
            x++;
        }
        //세로축을 벗어나면 종료
        if(x+key.length > lock.length)
            return;

        //또 새로운 lock을 만들어주고
        int[][] copyLock = new int[lock.length][lock.length];

        //카피본에 깊은 복사를 해준다.
        for(int i=0;i<lock.length;i++){
            copyLock[i] = lock[i].clone();
        }


        boolean isFail = false;

        loop:
            //키를 돌면서
            for(int i=0;i<key.length;i++){
                for(int j=0;j<key.length;j++){
                    //키가 돌기 부분일때
                    if(key[i][j] == 1){
                        //lock도 돌기면
                        if(copyLock[i+x][j+y] == 1){
                            //그 열쇠는 맞지 않는 키임
                            isFail = true;
                            //루프 종료
                            break loop;
                        }
                        //lock이 홈이면
                        //키의 값을 그 자리에 넣어준다
                        copyLock[i+x][j+y] = key[i][j];
                    }
                }
            }
            //키의 돌기와 자물쇠의 돌기가 만나지 않았을 경우
            if(!isFail){
                loop:
                //배열을 세배로 키우고
                //중앙에 자물쇠의 값들을 넣어놓았는데
                //그 중앙에 있는 자물쇠의 값들을 확인하는 과정
                for(int i=0;i<lock.length/3;i++){
                    for(int j=0;j<lock.length/3;j++){
                        //열쇠와 자물쇠가 맞지 않으면 실패
                        // 돌기의 값은 1이기 때문에 열쇠가 딱 맞는다면 자물쇠의 모든 값은 1이 되어야함
                        if(copyLock[i+lock.length/3][j+lock.length/3] != 1){
                            isFail = true;
                            break loop;
                        }
                    }
                }
            }
            //실패하지 않았으면
            if(!isFail)
                //ㅑisOk를 true 켜준다.
                isOk = true;

            //키 배열을 오른쪽으로 한칸 이동하여 다시 확인
            check(key,lock,x,y+1);
    }

    private int[][] turnArray(int[][] key){
        int[][] copy = new int[key.length][key[0].length];

        for(int i=0;i<key.length;i++){
            for(int j=0;j<key[i].length;j++){
                copy[(key.length-1)-j][i] = key[i][j];
            }
        }
        return copy;
    }

}

