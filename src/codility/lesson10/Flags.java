package codility.lesson10;

import java.util.ArrayList;
import java.util.List;

public class Flags {
    public static void main(String[] args) {
        int[] arr = {1,5,3,4,3,4,1,2,3,4,6,2};
        Flags flags = new Flags();
        System.out.println(flags.solution(arr));
    }

    public int solution(int[] A) {
        List<Integer> peakList = new ArrayList<>();
        for(int i=1;i<A.length-1;i++){
            if(A[i-1] < A[i] && A[i] > A[i+1])
                peakList.add(i);
        }

        if(peakList.size() <= 1)
            return peakList.size();

        int res = 1;
        int maxLen = peakList.size();
        int idx = 1;
        while(idx <= maxLen){
            //먼저 깃발의 개수를 정하고
            int flag = (maxLen + idx) / 2;
            boolean isPossible = false;
            int used = 0; //사용한 깃발의 개수
            int mark = peakList.get(0); // 깃발이 있어야하는 최소 위치
            //peak를 돌면서
            for(int i=0;i<peakList.size();i++){
                //다음 peak이 깃발이 있는 지점보다 더 멀리 있으면
                if(peakList.get(i) >= mark){
                    //깃발을 꽂고
                    used++;
                    //다음 깃발이 있어야 하는 위치를 mark하고
                    mark = peakList.get(i) + flag;
                    //깃발을 다 쓰면 break;
                    if(used == flag){
                        isPossible = true;
                        break;
                    }
                }
            }
            if(isPossible){
                res = flag;
                idx = flag + 1;
            }else{
                maxLen = flag - 1;
            }
        }

        return res;
    }
}
