package kakao.blind2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/*
 * https://dundung.tistory.com/124
 */
public class KAKAO_후보키_BITMASK {
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        KAKAO_후보키_BITMASK kakao_후보키_bitmask = new KAKAO_후보키_BITMASK();
        System.out.println(kakao_후보키_bitmask.solution(relation));
    }

    public static int solution(String[][] relation) {
        int n = relation.length;
        int m = relation[0].length;
        List<Integer> ans = new ArrayList<>();
        for(int i=1; i<=(1<<m)-1; i++) { //1부터 전체집합 (1<<m)-1까지
            Set<String> set = new HashSet<>();
            for(int j=0; j<n; j++) {
                StringBuilder sb = new StringBuilder();
                for(int k=0; k<m; k++) {
                    if((i&(1<<k)) > 0) { // 정수 k가 비트마스크 i에 포함되어있다면
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size()==n && check(ans, i)) {
                ans.add(i);
            }
        }
        return ans.size();
    }
    public static boolean check(List<Integer> ans, int now) { //최소성검사
        for(int i=0; i<ans.size(); i++) {
            if((ans.get(i)&now)==ans.get(i)) {
                return false;
            }
        }
        return true;
    }
}
