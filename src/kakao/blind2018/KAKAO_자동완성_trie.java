package kakao.blind2018;

public class KAKAO_자동완성_trie {
    public static void main(String[] args) {
        KAKAO_자동완성_trie kakao_자동완성_trie = new KAKAO_자동완성_trie();
        String[] words = {"word", "war", "warrior", "world"};
        System.out.println(kakao_자동완성_trie.solution(words));
    }
    public int solution(String[] words){
        int answer = 0;
        Trie trie = new Trie();
        trie.num = -1;
        for(String word : words)
            trie.insert(word);

        for(String word : words)
            answer += trie.find(word);

        return answer;
    }
    public class Trie{
        int num = 0;
        Trie[] sub = new Trie[26];

        void insert(String key){
            int idx = 0;
            Trie trie;
            //key의 첫번째 글자가 trie에 없을 경우
            if(this.sub[toNumber(key.charAt(idx))] == null){
                //trie에 새로운 객체를 만들어서 채워넣는다.
                trie = this.sub[toNumber(key.charAt(idx))] = new Trie();
            //첫번째 글자가 없다면
            }else{
                //trie에 기존의 값을 넣어주고
                trie = this.sub[toNumber(key.charAt(idx))];
                //num을 1로 초기화한다
                trie.num = 1;
            }
            idx++;
            //idx가 key의 길이보다 작은 동안에
            while(idx < key.length()){
                //다음 글자를 숫자로 만들고
                int next = toNumber(key.charAt(idx));
                //그 숫자의 배열이 비어있다면
                if(trie.sub[next] == null)
                    //채워주고
                    trie.sub[next] = new Trie();
                //비어있지 않다면
                else
                    // 그 값의 num에 1을 넣어준다.
                    trie.sub[next].num = 1;

                //sub로 이동
                trie = trie.sub[next];
                idx++;
            }
        }

        int find(String key){
            int cnt=1, idx = 0;
            //key의 첫번째 문자의 값을 trie로 초기화
            Trie trie = this.sub[toNumber(key.charAt(idx))];
            idx++;
            //idx가 key의 길이보다 작은 동안에
            while(idx < key.length()){
                int next = toNumber(key.charAt(idx));
                //trie에 num 이 0 이면 중복이 없는 경우이므로 break
                if(trie.num == 0)
                    break;
                cnt++;
                trie = trie.sub[next];
                idx++;
            }
            return cnt;
        }

        int toNumber(char c){
            return c - 'a';
        }
    }
}
