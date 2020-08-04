package programmers.level3;

import java.util.*;

public class Level3_불량사용자 {
    public static void main(String[] args) {
        Level3_불량사용자 level3_불량사용자 = new Level3_불량사용자();
        String user_id[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String banned_id[] = {"fr*d*", "abc1**"};
        System.out.println(level3_불량사용자.solution(user_id, banned_id));
    }
    private boolean[] visited;
    private Set<String> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {

        visited = new boolean[user_id.length];
        dfs(0, "", user_id, banned_id);

        return set.size();
    }

    private void dfs(int n, String str, String[] user_id, String[] banned_id) {
        if(n == banned_id.length){
            String[] strArr = str.split(" ");

            Arrays.sort(strArr);
            StringBuilder sb = new StringBuilder();
            for(String s : strArr){
                sb.append(s);
            }
            set.add(sb.toString());
            return;
        }
        String reg = banned_id[n].replace("*", "[\\w\\d]");

        for(int i=0;i< user_id.length;i++){
            if(user_id[i].matches(reg) && !visited[i]){
                visited[i] =true;
                dfs(n+1, str+ " " +user_id[i], user_id, banned_id);
                visited[i] = false;
            }
        }

    }

}
