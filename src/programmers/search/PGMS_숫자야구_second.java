package programmers.search;

import java.util.*;

public class PGMS_숫자야구_second {
    public static void main(String[] args) {
        PGMS_숫자야구_second pgms_숫자야구_second = new PGMS_숫자야구_second();
        int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
        System.out.println(pgms_숫자야구_second.solution(baseball));
    }

    public int solution(int[][] baseball) {

        Set<String> set = new HashSet<>();

        for(int i=123; i<=987; i++){
            boolean isTrue = false;
            String num = String.valueOf(i);
            String[] numArr = num.split("");

            if(numArr[0].equals("0") || numArr[1].equals("0") || numArr[2].equals("0"))
                continue;

            if(numArr[0].equals(numArr[1]) || numArr[1].equals(numArr[2]) || numArr[2].equals(numArr[0]))
                continue;

            for(int j=0;j<baseball.length;j++){
                if(!checkStrikeAndBall(num, String.valueOf(baseball[j][0]), baseball[j][1], baseball[j][2])){
                    isTrue = true;
                    break;
                }
            }
            if(!isTrue)
                set.add(num);
        }

        return set.size();
    }

    public boolean checkStrikeAndBall(String num1, String num2, int strike, int ball){
        String[] num1Arr = num1.split("");
        String[] num2Arr = num2.split("");

        for(int i=0;i<3;i++){
            if(num1Arr[i].equals(num2Arr[i]))
                strike --;
        }

        List<String> list = Arrays.asList(num2Arr);
        for(int i=0;i<3;i++){
            System.out.println(list.indexOf(num1Arr[i]));
            if(list.contains(num1Arr[i]) && list.indexOf(num1Arr[i]) != i){
                ball--;
            }
        }

        if(strike == 0 && ball == 0)
            return true;
        return false;
    }
}
