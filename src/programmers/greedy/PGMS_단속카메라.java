package programmers.greedy;

import java.util.Arrays;
import java.util.Comparator;

public class PGMS_단속카메라 {
    public static void main(String[] args) {
        PGMS_단속카메라 pgms_단속카메라 = new PGMS_단속카메라();
        int[][] routes = {{-20, 15}, {-14, -5}, {-18, -13}, {-5, -3}};
        System.out.println(pgms_단속카메라.solution(routes));
    }

    public int solution(int[][] routes) {
        int answer = 0;

        int max = Integer.MIN_VALUE;
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));

        for(int i=0;i<routes.length;i++) {
            if(max < routes[i][0]) {
                max = routes[i][1];
                answer++;
            }
        }
        return answer;
    }
}
