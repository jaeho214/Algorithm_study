package programmers.bfs_dfs;

import java.util.*;

public class PGMS_여행경로_second {
    public static void main(String[] args) {
        PGMS_여행경로_second pgms_여행경로_second = new PGMS_여행경로_second();
        String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};
        System.out.println(pgms_여행경로_second.solution(tickets));
    }
    private String[][] tickets;
    private int len;
    private boolean[] visited;
    private List<String> res = new ArrayList<>();
    public String[] solution(String[][] tickets) {

        this.tickets = new String[tickets.length][tickets[0].length];
        this.visited = new boolean[tickets.length];
        this.len = tickets.length;

        for(int i=0;i<tickets.length;i++){
            for(int j=0;j<tickets[i].length;j++){
                this.tickets[i][j] = tickets[i][j];
            }
        }
        for(int i=0;i<len;i++){
            if(tickets[i][0].equals("ICN")){
                visited[i] = true;
                dfs(tickets[i][1], 0, tickets[i][0] + " ");
                visited[i] = false;
            }
        }

        Collections.sort(res);

        return res.get(0).split(" ");
    }

    private void dfs(String des, int cnt, String str){
        if(cnt == len-1){
            str += des;
            res.add(str);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            if(!visited[i] && tickets[i][0].equals(des)){
                visited[i] = true;
                dfs(tickets[i][1], cnt+1, str + tickets[i][0] + " ");
                visited[i] = false;
            }
        }
    }


}
