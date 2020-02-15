package codility.lesson9;

public class MaxProfit {
    public static void main(String[] args) {
        int[] a = {8};
        MaxProfit maxProfit = new MaxProfit();
        System.out.println(maxProfit.solution(a));
    }
    public int solution(int[] A) {
        if(A.length == 0)
            return 0;
        int min = A[0];
        int res=0, profit=0;

        for(int i=1;i<A.length;i++){
            profit = A[i] - min;
            min = Math.min(min, A[i]);
            res = Math.max(res, profit);
        }
        if(profit < 0)
            return 0;
        return res;
    }

}
