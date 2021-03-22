package hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HackerRank_The_Coin_Change_Problem {
    public static void main(String[] args) {
        List<Long> c = new ArrayList<>();
        c.add(2l);
        c.add(5l);
        c.add(3l);
        c.add(6l);

        System.out.println(getWays(10 , c));
    }

    public static long getWays(int n, List<Long> c) {
        // Write your code here

        Map<Long, Long> dp = new HashMap<>();

        dp.put(0l, 1l);
        for(int i=1;i<=n;i++){
            dp.put((long)i, 0l);
        }

        for(long coin : c) {
            for (long i = coin; i <= n; i++) {
                dp.put(i, dp.get(i) + dp.get(i - coin));
            }
        }

        return dp.get((long)n);
    }
}
