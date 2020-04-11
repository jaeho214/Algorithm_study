package naver.HackDay2020;

import java.util.*;

public class HACKDAY_1 {
    public static void main(String[] args) {
        HACKDAY_1 hackday_1 = new HACKDAY_1();

        int[][] delivery = {{5, 6, 0}, {1, 3, 1}, {1, 5, 0}, {7, 6, 0}, {3, 7, 1}, {2, 5, 0}};
        System.out.println(hackday_1.solution(7, delivery));
    }


    public String solution(int n, int[][] delivery) {
        Set<Integer> impossible = new HashSet<>();
        Set<Integer> possible = new HashSet<>();
        char[] check = new char[n+1];
        Arrays.fill(check, '?');
        for(int i=0;i<delivery.length;i++){
            if(delivery[i][2] == 1){
                possible.add(delivery[i][0]);
                possible.add(delivery[i][1]);
            }else if(delivery[i][2] == 0){
                if(impossible.contains(delivery[i][0]) || impossible.contains(delivery[i][1]))
                    continue;

                if(!possible.contains(delivery[i][0]))
                    impossible.add(delivery[i][0]);
                if(!possible.contains(delivery[i][1]))
                    impossible.add(delivery[i][1]);

            }
        }

        for(int im : impossible){
            check[im] = 'X';
        }
        for(int po : possible){
            check[po] = 'O';
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<check.length;i++)
            sb.append(check[i]);

        return sb.toString();
    }

}
