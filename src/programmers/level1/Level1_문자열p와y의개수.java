package programmers.level1;

public class Level1_문자열p와y의개수 {

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        s = s.toUpperCase();
        int pCnt=0, yCnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'P'){
                pCnt ++;
            }else if(s.charAt(i) == 'Y'){
                yCnt ++;
            }
        }
        if(pCnt == 0 && yCnt == 0)
            return true;

        if(pCnt == yCnt)
            return true;
        else
            return false;

    }

}
