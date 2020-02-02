package binarySearch;

public class PGMS_입국심사 {
    public static void main(String[] args) {
        int[] times = {2,2};
        PGMS_입국심사 pgms_입국심사 = new PGMS_입국심사();
        System.out.println(pgms_입국심사.solution(1, times));
    }

    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;

        for(int i : times){
            max = Math.max(i, max);
        }

        long low = 0;
        long high = max * n;
        while(low <= high){
            long mid = (low + high) / 2;
            long sum = 0;
            for(int time : times){
                sum += mid/time;
            }
            if(sum < n){
                low = mid + 1;
            }else{
                answer = Math.min(mid, answer);
                high = mid - 1;
            }
        }
        return answer;
    }
}
