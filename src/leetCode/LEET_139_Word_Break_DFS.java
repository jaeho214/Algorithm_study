package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 건영선배의 코드
 * map 으로 가능하거나 불가능한 것들을 저장하면서 시간을 줄이는 코드
 * 이것도 사실 map에 저장하기 때문에 DP로 볼 수 있을거같다
 */
public class LEET_139_Word_Break_DFS {
    public static void main(String[] args) {
        LEET_139_Word_Break_DFS word_break = new LEET_139_Word_Break_DFS();
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(word_break.wordBreak("catsandog", wordDict));
    }
    private Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        //이미 리스트에 포함된 단어라면 true
        if(wordDict.contains(s)) return true;

        //이미 확인을 했던 단어라면 그 단어의 가능성 여부를 리턴
        if(map.get(s) != null) return map.get(s);

        for(int i=1;i<=s.length();i++){
            //앞에서부터 단어를 확인하면서
            String str = s.substring(0, i);
            //그 단어가 리스트에 포함되어 있고 그 단어의 뒷부분들도 가능하다면
            if(wordDict.contains(str) && wordBreak(s.substring(i), wordDict)){
                //map에 가능한걸 저장
                map.put(s, true);
                return true;
            }
        }

        //모두 돌았다면 실패
        map.put(s, false);
        return false;
    }
}
