package hackerrank.ict;

import java.util.*;

public class Number4 {
    public static void main(String[] args) {
        System.out.println(stockPairs(Arrays.asList(
                6,
                12,
                3,
                9,
                3,
                5,
                1,
                12), 12));
    }


    public static int stockPairs(List<Integer> stocksProfit, long target) {
        int count = 0;

        Set<Integer> set = new HashSet<>();
        int halfCnt = 0;
        for(int stock : stocksProfit) {
            if(target / 2 == stock)
                halfCnt++;
            set.add(stock);
        }

        count += halfCnt/2;

        for(int stock : stocksProfit) {
            if(target/2 == stock)
                continue;
            if(set.contains((int)target-stock)) {
                set.remove((int)target-stock);
                set.remove(stock);
                count++;
            }
        }
        return count;
    }
}
