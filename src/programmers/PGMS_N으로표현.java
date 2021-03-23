package programmers;

import java.util.HashSet;
import java.util.Set;

public class PGMS_N으로표현 {
    public static void main(String[] args) {
        PGMS_N으로표현 n으로표현 =new PGMS_N으로표현();
        System.out.println(n으로표현.solution(5, 12));
    }

    public int solution(int N, int number){

        Set<Integer>[] setArr = new Set[9];
        int tmp = N;
        for(int i=1;i<9;i++){
            setArr[i] = new HashSet<>();
            setArr[i].add(tmp);
            tmp = tmp * 10 + N;
        }

        for(int i=1;i<9;i++){
            for(int j=1;j<i;j++){
                for(int a : setArr[j]){
                    for(int b : setArr[i-j]){
                        setArr[i].add(a+b);
                        setArr[i].add(a-b);
                        setArr[i].add(b-a);
                        setArr[i].add(a*b);
                        if(a!=0)
                            setArr[i].add(b/a);
                        if(b!=0)
                            setArr[i].add(a/b);
                    }
                }
            }
        }

        for(int i=1;i<9;i++){
            if(setArr[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
