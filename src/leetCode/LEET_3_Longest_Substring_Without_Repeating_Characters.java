package leetCode;

import java.util.*;

/**
 * 큐로 풀고 셋으로도 풀어봤는데
 * contains 함수때문인지 큐가 많이 느렸다
 */
public class LEET_3_Longest_Substring_Without_Repeating_Characters {
    public static void main(String[] args) {
        LEET_3_Longest_Substring_Without_Repeating_Characters longestSubstringWithoutRepeatingCharacters = new LEET_3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring_QUEUE("abcabcbb"));
    }

    public int lengthOfLongestSubstring_QUEUE(String s) {

        Queue<Character> q = new LinkedList<>();
        int answer = 0;
        int idx = 0;

        while(idx < s.length()){
            if(q.contains(s.charAt(idx))){
                q.poll();
            }else{
                q.offer(s.charAt(idx++));
                answer = Math.max(answer, q.size());
            }
        }

        return answer;
    }

    public int lengthOfLongestSubstring_SET(String s) {

        Set<Character> set = new HashSet<>();
        int start = 0, end = 0;
        int answer = 0;

        while(end < s.length()){
            if(set.contains(s.charAt(end))){
                set.remove(s.charAt(start++));
            }else {
                set.add(s.charAt(end++));
                answer = Math.max(answer, end-start);
            }
        }
        return answer;
    }
}
