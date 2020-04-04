package kakao.internship2019;

import java.util.*;

public class KAKAO_불량사용자 {
    public static void main(String[] args) {
        KAKAO_불량사용자 kakao_불량사용자 = new KAKAO_불량사용자();
        String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
        System.out.println(kakao_불량사용자.solution(user_id, banned_id));
    }
    Set<Integer> set = new HashSet<>();
    public int solution(String[] user_id, String[] banned_id) {
        dfs(user_id, banned_id, 0, 0);

        return set.size();
    }

    private void dfs(String[] user_id, String[] banned_id, int bit, int cnt) {
        if(cnt == banned_id.length){
            set.add(bit);
            return;
        }

        //정규표현식을 통해서 매칭
        String reg = banned_id[cnt].replace("*", "[\\w\\d]");
        //user_id를 돌면서
        for(int i=0; i<user_id.length; i++){
            //해당 user_id를 이미 포함시켰을 경우 continue
            //왼쪽에서부터 판단하기 때문에 >> 를 사용
            if(((bit>>i) & 1) == 1 )
                continue;
            //banned_id에 매칭이 안될 경우 continue
            if(!user_id[i].matches(reg))
                continue;
            //해당 user_id의 비트를 체킹하고 dfs
            dfs(user_id, banned_id, (bit | 1<<i), cnt+1);
        }


    }

}
