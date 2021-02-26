package leetCode;

import java.util.Arrays;
import java.util.List;

/**
 * 영준이의 코드
 * DP가 많이 모자르니까 DP를 열심히 풀어보자
 */
public class LEET_139_Word_Break_DP {
    public static void main(String[] args) {
        LEET_139_Word_Break_DP word_break = new LEET_139_Word_Break_DP();
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(word_break.wordBreak("catsandog", wordDict));
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()+1];

        Arrays.fill(dp, -1);

        dp[0] = 0;

        for(int i=0; i<s.length(); i++){
            //i번째 인덱스까지 단어가 완성이 되었다면
            if(dp[i] != -1){
                // i+1번째 인덱스부터 돌면서
                for(int j=i+1; j<=s.length(); j++){
                    //단어를 확장하면서
                    String str = s.substring(i, j);

                    //그 단어가 리스트에 포함되어 있다면
                    if(wordDict.contains(str)){
                        //그 단어의 마지막 글자 인덱스 자리에 메모이제이션
                        dp[j] = i;
                    }
                }
            }
        }

        //마지막 글자의 인덱스가 -1이라면 불가능하다는 뜻
        return dp[dp.length-1] != -1;
    }
}
