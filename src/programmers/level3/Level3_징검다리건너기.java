package programmers.level3;

public class Level3_징검다리건너기 {
    public static void main(String[] args) {
        Level3_징검다리건너기 level3_징검다리건너기 = new Level3_징검다리건너기();
        int[] stones = {1,1,200,1,1};
        System.out.println(level3_징검다리건너기.solution(stones, 1));
    }

    public int solution(int[] stones, int k) {
        int answer = 0;

        int min = getMin(stones);
        int max = getMax(stones);

        while(min <= max){
            int mid = (min+max) / 2;
            if(isPossible(stones, mid, k)) {
                answer = Math.max(mid, answer);
                min = mid+1;
            }else{
                max = mid-1;
            }
        }
        return answer;
    }

    private boolean isPossible(int[] stones, int mid, int k) {
        int cnt = 0;
        for(int stone : stones){
            if(stone >= mid){
                cnt = 0;
            }else{
                cnt++;
            }
            if(cnt==k) {
                return false;
            }
        }
        return true;
    }

    private int getMin(int[] stones) {
        int min = Integer.MAX_VALUE;
        for(int stone : stones)
            min = Math.min(stone, min);

        return min;
    }

    private int getMax(int[] stones) {
        int max = Integer.MIN_VALUE;
        for(int stone : stones)
            max = Math.max(stone, max);

        return max;
    }
}
