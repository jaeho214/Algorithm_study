package codility.lesson7;

import java.util.Stack;
/*
 * https://denken-y.tistory.com/entry/Codility-Fish
 */
public class Fish {
    public static void main(String[] args) {
        Fish fish = new Fish();
        int[] a = {2,3,2,1,5};
        int[] b = {0,1,0,0,0};
        System.out.println(fish.solution(a,b));
    }

    public int solution(int[] A, int[] B) {
        int cnt = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<A.length;i++){
            //하류로 내려가는 물고기들을 스택에 넣어두고
            if(B[i] == 1)
                stack.add(A[i]);
            //상류로 올라가는 물고기들을 만나면
            else if(B[i] == 0){
                //하류로 내려오는 물고기가 없고 상류로 올라가는 물고기만 있다면
                if(stack.isEmpty())
                    //그 물고기는 살았다.
                    cnt++;
                else{
                    //하류로 내려오는 물고기들을 살피면서
                    while(!stack.isEmpty()){
                        //상류로 오르는 물고기보다 숫자가 큰 물고기가 스택에 존재하면
                        if(stack.peek() > A[i])
                            //브레이크
                            break;
                        //만약 상류로 오르는 물고기가 하류로 내려오는 어떠한 물고기보다도 크다면
                        else
                            //그 내려오는 물고기들은 먹혔다.
                            stack.pop();
                    }
                    //상류를 오르는 물고기가 하류로 내려오는 물고기를 모두 먹었다면
                    if(stack.isEmpty())
                        //그 물고기는 살았다.
                        cnt++;
                }
            }
        }

        //하류로 내려오던 물고기들이 남아있을 수도 있으므로 +
        return cnt+stack.size();
    }
}
