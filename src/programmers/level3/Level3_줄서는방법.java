package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Level3_줄서는방법 {
    public static void main(String[] args) {
        Level3_줄서는방법 level3_줄서는방법 = new Level3_줄서는방법();
        System.out.println(level3_줄서는방법.solution(50, 30));
    }

    public int[] solution(int n, long k){
        int[] answer = new int[n];
        //n개의 숫자일 때의 경우의 수
        long dp[] = new long[n+1];

        List<String> q = new ArrayList<>();
        List<String> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(String.valueOf(i));
        }

        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] * i;
        }

        long from = k;
        long to = 0L;
        while(k>0){
            to = dp[n-1];
            //나누어 떨어지는 경우에는 나눈값-1 번째의 숫자가 맨앞에 나오고 나머지 숫자 역순
            if(from % to == 0){
                int num = (int) ((from/to)-1);
                q.add(list.remove(num));
                for(int i=list.size()-1;i>=0;i--)
                    q.add(list.get(i));
                break;
            }else{
                //나누어 떨어지지 않으면 나눈값 번째 숫자를 add
                q.add(list.remove((int)(from/to)));
                //from의 값을 to로 나눈 나머지값으로 갱신하며 진행
                from %= to;
            }
            n--;
        }

        for(int i=0;i<q.size();i++){
            answer[i] = Integer.parseInt(q.get(i));
        }

        return answer;
    }

}
