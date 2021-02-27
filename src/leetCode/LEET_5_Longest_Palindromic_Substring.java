package leetCode;

/**
 * 홀수개던 짝수개던 구분자를 넣어주면 쌉가능
 */
public class LEET_5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        LEET_5_Longest_Palindromic_Substring longest_palindromic_substring = new LEET_5_Longest_Palindromic_Substring();
        System.out.println(longest_palindromic_substring.longestPalindrome("babab"));
    }

    public static class Palindrome{
        int[] memo;
        int idx;
        int value;

        public Palindrome(int[] memo, int idx, int value) {
            this.memo = memo;
            this.idx = idx;
            this.value = value;
        }
    }

    char SEP = '#';

    public String longestPalindrome(String s) {
        s = convertString(s);

        Palindrome max = palindrome(s);

        StringBuilder answer = new StringBuilder();

        if(s.charAt(max.idx) != SEP) {
            answer.append(s.charAt(max.idx));
        }
        int idx = 1;
        while(idx <= max.memo[max.idx]){
            if(s.charAt(max.idx-idx) == SEP || s.charAt(max.idx+idx) == SEP){
                idx++;
                continue;
            }
            answer.insert(0, s.charAt(max.idx-idx));
            answer.append(s.charAt(max.idx+idx));
            idx++;
        }
        return answer.toString();
    }

    private Palindrome palindrome(String s) {
        int len = s.length();
        int[] memo = new int[len];

        int center = 0, right = 0;
        int max_value = 0, max_idx = 0;

        for(int i=0;i<len;i++){
            int left = 2*center-i;

            if(i < right)
                memo[i] = Math.min(memo[left], right-i);
            else
                memo[i] = 0;

            while(i-memo[i]-1 >= 0 && i+memo[i]+1 < len && s.charAt(i-memo[i]-1) == s.charAt(i+memo[i]+1)) memo[i]++;

            if(max_value < memo[i]){
                max_value = memo[i];
                max_idx = i;
            }

            if(right < i + memo[i]){
                right = i + memo[i];
                center = i;
            }
        }

        return new Palindrome(memo, max_idx, max_value);
    }

    private String convertString(String s) {
        StringBuilder sb = new StringBuilder(SEP);
        sb.append(SEP);

        for(int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append(SEP);
        }

        return sb.toString();
    }
}
