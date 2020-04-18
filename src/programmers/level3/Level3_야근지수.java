package programmers.level3;

import java.util.Arrays;

public class Level3_야근지수 {
    public static void main(String[] args) {
        Level3_야근지수 level3_야근지수 = new Level3_야근지수();
        int[] works = {4,3,3};
        System.out.println(level3_야근지수.solution(4, works));
    }

    public long solution(int n, int[] works) {
        long answer = 0;

        //오름차순으로 정렬한 후
        Arrays.sort(works);

        while(n>0){
            n--;
            if(works[works.length-1] == 0)
                break;
            //제일 큰 값에서 -1
            works[works.length-1]--;
            //맨 뒤에서부터 앞으로 가면서 배열 재정렬
            for(int i=works.length-1; i>=1;i--){
                if(works[i-1] > works[i]){
                    int tmp = works[i];
                    works[i] = works[i-1];
                    works[i-1] = tmp;
                    continue;
                }
                break;
            }
        }

        for(int work : works){
            answer += Math.pow(work, 2);
        }

        return answer;
    }
}
