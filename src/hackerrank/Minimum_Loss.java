package hackerrank;


import java.util.*;

public class Minimum_Loss {
    public static void main(String[] args) {
        long[] price = {2,1};
        System.out.println(minimumLoss(price));
    }

    public static class Pair implements Comparable<Pair> {
        private int idx;
        private long price;

        public Pair(int idx, long price) {
            this.idx = idx;
            this.price = price;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.price > o.price)
                return -1;
            else if(this.price < o.price)
                return 1;
            else
                return 0;
        }
    }

    static int minimumLoss(long[] price) {
        List<Pair> list = new ArrayList<>();

        int idx = 0;
        for(long p : price){
            list.add(new Pair(idx++, p));
        }
        Collections.sort(list);

        long answer = Long.MAX_VALUE;
        for(int i=1;i<list.size();i++){
            if(list.get(i-1).idx < list.get(i).idx)
                answer = Math.min(list.get(i-1).price - list.get(i).price, answer);
        }

        return (int)answer;
    }
}
