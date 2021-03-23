package leetCode;

import java.util.*;

public class Leetcode_139_Word_Break {
    public static void main(String[] args) {
        Leetcode_139_Word_Break word_break = new Leetcode_139_Word_Break();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("cats");
        wordDict.add("dog");
        wordDict.add("sand");
        wordDict.add("and");
        wordDict.add("cat");


        System.out.println(word_break.wordBreak_DFS("catsandog", wordDict));
    }

    public boolean wordBreak_DP(String s, List<String> wordDict) {

        int[] dp = new int[s.length()+1];

        Arrays.fill(dp, -1);

        dp[0] = 0;
        for(int i=0;i<s.length();i++){
            if(dp[i] != -1){
                //wordDict만 돌면서
                for(String word : wordDict){
                    if(s.startsWith(word, i))
                        dp[i+word.length()] = i;
                }
            }
        }

        return dp[s.length()] != -1;
    }

    public boolean wordBreak_DFS(String s, List<String> wordDict) {
        return wordBreak_DFS(s, 0, wordDict, new boolean[s.length()]);
    }

    private boolean wordBreak_DFS(String s, int begin, List<String> wordDict, boolean[] fails) {
        //begin이 딱 s를 넘어선거면 딱 맞는다는 소리임
        if(begin == s.length()) return true;
        //begin이 이미 실패했었다면 (메모이제이션)
        else if(fails[begin]) return false;

        for(final String word : wordDict){
            //현재 인덱스부터 wordDict를 돌면서
            // 이어붙였을 때 길이가 넘어가면 continue
            if(begin + word.length() > s.length())
                continue;

            //begin에서부터 word가 커버할 수 있는 것들만
            if(!s.startsWith(word, begin))
                continue;

            //커버할 수 있는 word 뒤부터 다시 재귀를 돌린다.
            if(wordBreak_DFS(s, begin+word.length(), wordDict, fails))
                return true;
        }

        //다 돌았다면 begin 인덱스에선 wordDict에 있는 단어는 없다는 뜻
        fails[begin] = true;
        //불가능 리턴
        return false;
    }
}
