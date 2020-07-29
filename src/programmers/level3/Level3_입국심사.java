package programmers.level3;

public class Level3_입국심사 {
    public static void main(String[] args) {
        Level3_입국심사 level3_입국심사 = new Level3_입국심사();
        int[] times = {10};
        System.out.println(level3_입국심사.solution(1000000000, times));
    }
    private int[] times;
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        this.times = times.clone();

        long max = 0;
        for(int i=0;i<times.length;i++){
            max = Math.max(times[i], max);
        }

        long low = 0;
        long high = max * n;
        while(low <= high){
            long mid = (low + high) / 2;
            if(isPossible(mid, n)){
                answer = Math.min(answer, mid);
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return answer;
    }

    private boolean isPossible(long mid, long n) {

        for(int time : this.times){
            n -= mid / time;
            if(n<=0)
                return true;
        }

        return false;
    }

}
