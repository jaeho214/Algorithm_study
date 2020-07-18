package programmers.search;

import java.util.HashSet;
import java.util.Set;

public class PGMS_소수찾기_second {
    public static void main(String[] args) {
        PGMS_소수찾기_second pgms_소수찾기_second = new PGMS_소수찾기_second();
        System.out.println(pgms_소수찾기_second.solution("011"));
    }
    private Set<Integer> res = new HashSet<>();
    private String[] numArr;
    private boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;

        this.numArr = numbers.split("");
        this.visited = new boolean[numArr.length];

        for(int i=0;i<numArr.length;i++){
            visited[i] = true;
            dfs(numArr[i]);
            visited[i] = false;
        }

        return res.size();
    }

    private void dfs(String str){
        int num = Integer.parseInt(str);
        if(isPrime(num)){
            if(num != 0 && num != 1)
                res.add(num);
        }

        for(int i=0; i<numArr.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            dfs(str + numArr[i]);
            visited[i] = false;
        }
    }


    private static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }
}
