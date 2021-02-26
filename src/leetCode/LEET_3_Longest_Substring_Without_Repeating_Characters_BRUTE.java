package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 그냥 Brute-force로 풀어보았는데 역시나 시간초과
 */
public class LEET_3_Longest_Substring_Without_Repeating_Characters_BRUTE {
    public static void main(String[] args) {
        LEET_3_Longest_Substring_Without_Repeating_Characters_BRUTE longestSubstringWithoutRepeatingCharacters = new LEET_3_Longest_Substring_Without_Repeating_Characters_BRUTE();
        System.out.println(longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("a "));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++){
            if(s.length()-i < max)
                break;
            for(int j=i+1;j<=s.length();j++){
                String[] split = s.substring(i, j).split("");
                Set<String> set = new HashSet<>(Arrays.asList(split));
                if(set.size() != split.length)
                    break;
                max = Math.max(max, split.length);
            }
        }
        return max==Integer.MIN_VALUE ? 0 : max;
    }
}
