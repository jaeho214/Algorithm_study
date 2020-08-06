package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Level3_줄서는방법_second {
    public static void main(String[] args) {
        Level3_줄서는방법_second level3_줄서는방법_second = new Level3_줄서는방법_second();
        System.out.println(level3_줄서는방법_second.solution(4, 10));
    }

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> res = new ArrayList<>();
        List<Integer> list = fillList(n);
        long dp[] = totalCount(n);

        while(true){
            long num = dp[n-1];

            if(k % num == 0){
                res.add(list.remove((int) ((k/num)-1)));
                break;
            }else{
                res.add(list.remove((int) ((k/num))));
                k %= num;
            }
            n--;
        }
        if(!list.isEmpty()){
            for(int i=list.size()-1; i>=0; i--)
                res.add(list.get(i));
        }

        for(int i=0;i<res.size();i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    //리스트에 1,2,3 ... 순서대로 담는 메소드
    private List<Integer> fillList(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }

        return list;
    }

    //숫자가 n 개일때까지 경우의 수를 찾는 메소드
    private long[] totalCount(int n) {
        long dp[] = new long[n+1];

        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] * i;
        }

        return dp;
    }

}
