package codility.lesson13;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
/*
 * https://github.com/Mickey0521/Codility/blob/master/FibFrog.java
 */
public class FibFrog {
    public static void main(String[] args) {
        int arr[] = {0, 1, 1, 1, 1, 1, 1, 1, 1};
        FibFrog fibFrog = new FibFrog();
        System.out.println(fibFrog.solution(arr));
    }

    public int solution(int[] A) {
        ArrayList<Integer> fibonacci = new ArrayList<>();
        //A의 길이까지 fibonacci 구하여 리스트에 넣어주는 로직
        fibonacci.add(0);
        fibonacci.add(1);
        while(true){
            int temp1 = fibonacci.get(fibonacci.size()-1);
            int temp2 = fibonacci.get(fibonacci.size()-2);
            fibonacci.add(temp1 + temp2);

            if(temp1+temp2 > A.length)
                break;
        }

        //최소 횟수를 구하기 위해 큰 값부터 확인
        Collections.reverse(fibonacci);

        ArrayList<Point> q = new ArrayList<>();
        //q에 시작점(-1),움직인 횟수(0)을 객체로 add
        q.add(new Point(-1,0));

        int idx = 0;
        while(true){
            //불가능한 경우
            if(idx == q.size())
                return -1;

            //q에서 현재 위치를 꺼내오고
            Point current = q.get(idx);

            //fibonacci 리스트를 볼면서
            for(int n : fibonacci){
                //다음 위치를 정한다
                int next = current.x + n;

                //다음 위치가 목적지라면
                if(next == A.length)
                    //현재까지의 이동 +1을 리턴
                    return current.y + 1;

                //다음 위치가 벗어나거나 잎이 없다면 continue
                else if(next>A.length || next < 0 || A[next] ==0)
                    continue;

                //그게 아니라 다음 잎을 밟는 경우라면
                else{
                    //이동 횟수를 +1 하여 새로운 객체를 생성하고
                    Point temp = new Point(next, current.y+1);
                    //그 객체를 q에 add
                    q.add(temp);
                    //그 잎은 밟았으므로 0으로 바꿔주기
                    A[next] = 0;
                }
            }
            //현재 위치를 찾기위한 idx ++
            idx++;
        }
    }
}
