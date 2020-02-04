package programmers.greedy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class PGMS_섬연결하기 {
    public static void main(String[] args) {
        int[][] costs = {{1,0,1},{2,3,1},{0,3,3}};

        System.out.println(solution(4, costs));
    }


    public static int solution(int n, int[][] costs) {
        int answer = 0;
        boolean bridge[][] = new boolean[n][n];

        Arrays.sort(costs, (o1, o2) -> {
            if(o1[2] > o2[2])
                return 1;
            return -1;
        });

        Set<Integer> set = new LinkedHashSet<>();
        for(int i=0;i<costs.length;i++){

            if(bridge[costs[i][0]][costs[i][1]] && bridge[costs[i][1]][costs[i][0]])
                continue;

            set.add(costs[i][0]);
            set.add(costs[i][1]);

            bridge[costs[i][0]][costs[i][1]] = true;
            bridge[costs[i][1]][costs[i][0]] = true;

            for (Integer num : set) {
                boolean visited[] = new boolean[n];
                //다리가 건설된 섬들을 set에 넣어놓고 돌면서 통행 가능한지 판단
                connect(num, num, bridge, visited);
            }
            answer += costs[i][2];
        }
        return answer;
    }

    private static void connect(int ori,int num, boolean[][] bridge, boolean[] visited){
        visited[num] = true;

        for(int i=0;i<bridge.length;i++){
            if(bridge[num][i] && !visited[i]){
                bridge[ori][i] = true;
                bridge[i][ori] = true;
                connect(ori, i, bridge, visited);
            }
        }
    }


}
