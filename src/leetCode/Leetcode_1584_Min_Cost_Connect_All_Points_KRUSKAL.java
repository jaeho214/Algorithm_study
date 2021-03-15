package leetCode;

import java.util.*;

public class Leetcode_1584_Min_Cost_Connect_All_Points_KRUSKAL {
    public static void main(String[] args) {
        Leetcode_1584_Min_Cost_Connect_All_Points_KRUSKAL min_cost_connect_all_points = new Leetcode_1584_Min_Cost_Connect_All_Points_KRUSKAL();
        int[][] points = {{0,0}, {2,2}, {3,10}, {5,2}, {7,0}};
        System.out.println(min_cost_connect_all_points.minCostConnectPoints(points));
    }

    public class Pair{
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public class Distance implements Comparable<Distance>{
        Pair from;
        Pair to;
        int distance;

        public Distance(Pair from, Pair to) {
            this.from = from;
            this.to = to;
            this.distance = Math.abs(to.x - from.x) + Math.abs(to.y - from.y);
        }

        @Override
        public int compareTo(Distance o) {
            if(this.distance > o.distance)
                return 1;
            else if(this.distance < o.distance)
                return -1;
            return 0;
        }
    }

    public Pair findParent(Pair search) {
        if (parent.get(search).equals(search)) return search;

        Pair tmp = findParent(parent.get(search));
        parent.put(search, tmp);
        return tmp;
    }

    public void union(Pair a, Pair b) {
        Pair aParent = findParent(a);
        Pair bParent = findParent(b);

        parent.put(aParent, bParent);
    }

    Map<Pair, Pair> parent = new HashMap<>();
    public int minCostConnectPoints(int[][] points) {
        int answer = 0;

        List<Distance> distanceList = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            parent.put(new Pair(points[i][0], points[i][1]), new Pair(points[i][0], points[i][1]));
            for(int j=i+1;j<points.length;j++){
                Pair from = new Pair(points[i][0], points[i][1]);
                Pair to = new Pair(points[j][0], points[j][1]);
                distanceList.add(new Distance(from, to));
            }
        }

        distanceList.sort(Distance::compareTo);
        int cnt = 0;
        for(Distance distance : distanceList){
            if(!findParent(distance.from).equals(findParent(distance.to))){
                union(distance.from, distance.to);
                answer += distance.distance;
                cnt++;
            }
            if(cnt == points.length-1) break;
        }

        return answer;
    }
}
