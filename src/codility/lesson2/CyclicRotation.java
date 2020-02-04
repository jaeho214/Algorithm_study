package codility.lesson2;

import java.util.Stack;

public class CyclicRotation {

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int []A = {};
        int res[] = cyclicRotation.solution(A, 4);
        for(int i : res)
            System.out.println(i);
    }

    public int[] solution(int[] A, int K) {
        Stack<Integer> stack = new Stack<>();

        //배열이 비어있을 경우의 처리를 안해줌..
        if(A.length == 0)
            return A;

        for(int i : A)
            stack.add(i);

        int cnt = K;
        while(cnt>0){
            int num = stack.pop();
            stack.add(0, num);
            cnt --;
        }

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}
