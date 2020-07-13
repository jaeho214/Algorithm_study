package programmers.bfs_dfs;

import java.util.*;

public class PGMS_단어변환_second {

    public static void main(String[] args) {
        PGMS_단어변환_second pgms_단어변환_second = new PGMS_단어변환_second();
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(pgms_단어변환_second.solution("hit", "cog", words));
    }
    private int min = Integer.MAX_VALUE;
    private String target;
    private boolean visited[];
    private String words[];
    public int solution(String begin, String target, String[] words) {

        if(!Arrays.asList(words).contains(target))
            return 0;

        this.target = target;
        this.visited = new boolean[words.length];
        this.words = new String[words.length];

        for(int i=0;i<words.length;i++) {
            this.words[i] = words[i];
        }

        return bfs(begin);

        //dfs(begin, 0);

        //return min;
    }
    private int bfs(String begin){
        Queue<String> q = new LinkedList<>();
        q.offer(begin);

        Map<String, Integer> map = new HashMap<>();
        map.put(begin, 0);
        for(String word : words){
            map.put(word, 0);
        }

        while(!q.isEmpty()) {

            String poll = q.poll();
            if (poll.equals(target))
                return map.get(poll);

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && isPossible(poll, words[i])) {
                    q.offer(words[i]);
                    visited[i] = true;
                    map.put(words[i], map.get(poll) + 1);
                }
            }
        }

        return 0;
    }

    private void dfs(String str, int cnt) {
        if(str.equals(target)){
            min = Math.min(min, cnt);
            return;
        }

        for(int i=0;i<visited.length;i++){
            if(visited[i] || !isPossible(str, words[i]))
                continue;
            visited[i] = true;
            dfs(words[i], cnt+1);
            visited[i] = false;
        }

    }

    private boolean isPossible(String str1, String str2){
        int cnt = 0;
        for(int i=0;i<str1.length();i++){
            if(str1.charAt(i) != str2.charAt(i))
                cnt++;
        }

        if(cnt == 1)
            return true;
        return false;
    }
}
