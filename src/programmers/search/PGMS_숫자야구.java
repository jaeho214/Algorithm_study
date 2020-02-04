package programmers.search;

import java.util.*;

public class PGMS_숫자야구 {
    public static void main(String[] args) {
        PGMS_숫자야구 pgms_숫자야구 = new PGMS_숫자야구();
        int[][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        System.out.println(pgms_숫자야구.solution(baseball));
    }


    public int solution(int[][] baseball) {
        Queue<Integer> q = new LinkedList<>();
        Arrays.sort(baseball, (o1, o2) -> {
            if(o1[1] < o2[1])
                return 1;
            return -1;
        });

        if(baseball[0][1] == 3)
            return 1;
        //일단 스트라이크가 가장 많은 수를 기준으로 가능한 숫자들을 q에 저장
        for(int i=123;i<=987;i++){
            String target = String.valueOf(i);
            int[] n = strToArray(target);

            //숫자에 0이 포함되면 안되고
            if(n[0] == 0 || n[1] == 0 || n[2] == 0)
                continue;
            //겹치는 숫자가 있으면 안됨
            if(n[0] == n[1] || n[1] == n[2] || n[0] == n[2])
                continue;

            //스트라이크와 볼이 같으면 큐에 저장
            if(check(String.valueOf(baseball[0][0]),baseball[0][1], baseball[0][2], target)){
                q.add(i);
            }
        }
        Set<Integer> set = new LinkedHashSet<>();
        //큐에 넣어놨던 수들을 돌면서
        while(!q.isEmpty()){
            int num = q.poll();
            boolean isPossible = true;
            //나머지 배열들을 통해 스트라이크와 볼을 확인하고
            for(int i=1;i<baseball.length;i++){
                if(!check(String.valueOf(baseball[i][0]),baseball[i][1], baseball[i][2], String.valueOf(num))) {
                    isPossible = false;
                    break;
                }
            }
            //가능한 것들만 set에 저장
            if(isPossible)
                set.add(num);
        }

        return set.size();
    }

    //숫자를 한 자리씩 배열에 넣어주는 메소드
    private int[] strToArray(String target) {
        int num[] = new int[3];
        for(int i=0;i<target.length();i++){
            num[i] = target.charAt(i) - '0';
        }
        return num;
    }

    //스트라이크와 볼의 개수가 같은지 판단하는 메소드
    private boolean check(String num, int strike, int ball, String target) {
        int s = 0;
        int b = 0;
        for(int i=0;i<num.length();i++){
            for(int j=0;j<target.length();j++){
                if(num.charAt(i) == target.charAt(j)){
                    if(i==j)
                        s++;
                    else
                        b++;
                }
            }
        }
        if(s == strike && b == ball)
            return true;
        else
            return false;
    }

}
