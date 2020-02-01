package binarySearch;

import java.util.Arrays;
/*
 * 이분탐색은 O(n log n)으로 계산할 수 있다.
 * 이분 탐색의 범위가 되는 최소와 최대가 무엇인지 생각하고 그 안에서 최적값을 찾으면 된다.
 */
public class PGMS_예산 {

    public static void main(String[] args) {
        PGMS_예산 pgms_예산 = new PGMS_예산();
        int[] budgets = {5,5,5,15,25};
        System.out.println(pgms_예산.solution(budgets, 50));
    }

    public int solution(int[] budgets, int M) {
        long sum = 0;
        int maxBudget = Arrays.stream(budgets).max().getAsInt();

        //합을 구함 => 효율성 2번 문제 long으로 해결
        for(int i : budgets)
            sum += i;

        //예산보다 합이 낮으면 가장 큰 예산 출력
        if(sum <= M)
            return maxBudget;

        int low = 0; // 0부터
        int high = maxBudget; // 가장 큰 예산까지
        int targetLimit = 0; // 상한액
        long max = Integer.MIN_VALUE; // 여러 상한액을 대입해볼건데 가장 큰 값을 찾기 위한 변수

        while(low <= high){
            //중간값을 찾아서
            int mid = (low + high) / 2;
            //중간값을 상한액이라고 가정하고 필요한 총 예산을 구해본다/
            long total = check(budgets, mid);
            //그 예산과 총 예산이 같으면 그 상한액을 리턴하고
            if(total == M){
                return mid;
            //총 예산보다 적으면 상한액을 올릴 수 있는 여유가 있다는 뜻
            }else if(total < M){
                //중간값+1 을 low로 하여 이분 탐색할 수 있게끔
                low = mid + 1;
                //check 메소드를 통해 얻어온 필요 예산들 중 가장 큰 값을 찾을 수 있도록 한다.
                if(max < total){
                    max = total;
                    targetLimit = mid;
                }
            }else{
                //계속 찾다가 숫자가 애매해졌을 경우 high를 줄인다.
                high = mid - 1;
            }
        }

        return targetLimit;
    }

    //상한액을 가정하고 필요한 예산을 계산하는 메소드
    private long check(int[] budgets, int limit) {
        long total = 0;
        for(int budget : budgets){
            if(budget > limit)
                budget = limit;
            total += budget;
        }
        return total;
    }

}
