package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Level3_하노이의탑 {
    public static void main(String[] args) {
        Level3_하노이의탑 level3_하노이의탑 = new Level3_하노이의탑();
        System.out.println(level3_하노이의탑.solution(2));
    }
    List<int[]> list;
    public int[][] solution(int n) {
        list = new ArrayList<>();

        dfs(n, 1, 3, 2);

        int[][] answer = new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            int[] arr = list.get(i);
            answer[i][0] = arr[0];
            answer[i][1] = arr[1];
        }
        return answer;
    }

    private void dfs(int n, int from, int to, int mid) {
        if(n==1)
            move(from, to);
        else{
            dfs(n-1, from, mid, to);
            move(from, to);
            dfs(n-1, mid, to, from);
        }
    }

    private void move(int from, int to){
        list.add(new int[]{from, to});
    }
}
