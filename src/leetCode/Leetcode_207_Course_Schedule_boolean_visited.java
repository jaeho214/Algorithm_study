package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode_207_Course_Schedule_boolean_visited {

    public static void main(String[] args) {
        Leetcode_207_Course_Schedule_boolean_visited courseSchedule = new Leetcode_207_Course_Schedule_boolean_visited();
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(courseSchedule.canFinish(5, prerequisites));
    }

    private boolean[] visited;
    private boolean answer = true;
    private Map<Integer, List<Integer>> graph = new HashMap();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //그래프 생성
        for (int[] prerequisite : prerequisites) {
            if (graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                graph.put(prerequisite[1], list);
            }
        }

        //그래프를 돌면서 사이클이 있는지 확인
        for (int[] prerequisite : prerequisites) {
            visited = new boolean[numCourses + 1];
            isCycle(prerequisite[1], prerequisite[1]);
        }


        return answer;
    }

    private void isCycle(int num, int target) {
        if (!answer)
            return;
        if (visited[num])
            return;
        if (!graph.containsKey(num))
            return;

        visited[num] = true;

        for (int g : graph.get(num)) {
            //싸이클이 있으면 실패
            if (visited[g] && g == target) {
                answer = false;
                return;
            }
            isCycle(g, target);
        }
    }
}
