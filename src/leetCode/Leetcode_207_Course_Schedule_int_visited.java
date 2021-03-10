package leetCode;

import java.util.*;

public class Leetcode_207_Course_Schedule_int_visited {
    public static void main(String[] args) {
        Leetcode_207_Course_Schedule_int_visited courseSchedule = new Leetcode_207_Course_Schedule_int_visited();
        int[][] prerequisites = {{1,4},{2,4},{3,1},{3,2}};
        System.out.println(courseSchedule.canFinish(5, prerequisites));
    }

    private int[] visited;
    private Map<Integer, List<Integer>> graph = new HashMap();
    private static final int CHECKED = -1;
    private static final int FINISHED = 1;
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length <= 1)
            return true;

        for (int[] prerequisite : prerequisites) {
            if (graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                graph.put(prerequisite[1], list);
            }
        }

        visited = new int[numCourses + 1];
        for(int i=0; i<numCourses; i++){
            if(isCycle(i))
                return false;
        }

        return true;
    }

    private boolean isCycle(int num) {
        if (visited[num] == CHECKED)
            return true;
        if (visited[num] == FINISHED)
            return false;

        visited[num] = CHECKED;

        if (graph.containsKey(num)) {
            for (int j : graph.get(num)) {
                if (isCycle(j))
                    return true;
            }
        }

        visited[num] = FINISHED;

        return false;
    }
}
