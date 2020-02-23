package kakao.blind2020;


import java.util.HashMap;
/*
 * https://velog.io/@ptm0304/2020%EC%B9%B4%EC%B9%B4%EC%98%A4%EA%B3%B5%EC%B1%84-%EA%B0%80%EC%82%AC-%EA%B2%80%EC%83%89
 */
public class KAKAO_가사검색_trie {

    class Trie {
        char c;
        HashMap<Character, Trie> children;
        HashMap<Integer, Integer> numChildrenWithLen;

        Trie(char c) {
            this.c = c;
            children = new HashMap<Character, Trie>();
            //글자수에 따른 문자의 개수 (글자수 : 개수)
            numChildrenWithLen = new HashMap<Integer, Integer>();
        }

        Trie putChild(Trie t, int len) {
            //이미 그 문자를 가지고 있다면
            if (!children.containsKey(t.c)) {
                //새로운 자식을 만들어서 연결해준다.
                children.put(t.c, t);
            }
            //이미 그 길이의 문자가 있다면
            if (numChildrenWithLen.containsKey(len)) {
                //개수를 하나 더해주고
                numChildrenWithLen.put(len, numChildrenWithLen.get(len) + 1);
            }
            //없으면
            else {
                //새롭게 하나 추가해준다.
                numChildrenWithLen.put(len, 1);
            }
            return children.get(t.c);
        }

        Trie getChild(char c) {
            return children.get(c);
        }

        int getNumChildrenWithLen(int len) {
            if (numChildrenWithLen.containsKey(len)) return numChildrenWithLen.get(len);
            return 0;
        }
    }
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        KAKAO_가사검색_trie kakao_가사검색 = new KAKAO_가사검색_trie();
        System.out.println(kakao_가사검색.solution(words,queries));
    }
    public int[] solution(String[] words, String[] queries){
        int[] answer = new int[queries.length];
        //문자 그대로 찾기
        Trie root = new Trie('*');
        //단어들을 돌면서 trie에 저장
        for(int i=0;i<words.length;i++){
            String word = words[i];
            Trie prev = root;
            for(int j=0;j<word.length();j++){
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }

        for(int i=0;i<queries.length;i++){
            String query = queries[i];
            Trie trav = root;
            //?로 시작하면 continue
            if(query.charAt(0) == '?') continue;
            for(int j=0;j<query.length();j++){
                char c = query.charAt(j);
                //?가 접미사로 붙으면
                if(c=='?'){
                    //trie에서 글자 수가 같은 문자들의 개수를 answer에 넣어줌
                    answer[i] = trav.getNumChildrenWithLen(query.length());
                    break;
                }
                //다음 노드로 이동
                trav = trav.getChild(c);
                //끝까지 갔다면 없는거임
                if(trav == null){
                    answer[i] = 0;
                    break;
                }
            }
        }

        //문자를 뒤집고 찾기
        Trie rootReverse = new Trie('*');
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie prev = rootReverse;
            for (int j = word.length() - 1; j >= 0; j--) {
                char c = word.charAt(j);
                Trie curr = new Trie(c);
                prev = prev.putChild(curr, word.length());
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            Trie trav = rootReverse;
            if (query.charAt(0) != '?') continue;
            for (int j = query.length() - 1; j >= 0; j--) {
                char c = query.charAt(j);
                if (c == '?') {
                    answer[i] = trav.getNumChildrenWithLen(query.length());
                    break;
                }
                trav = trav.getChild(c);
                if (trav == null) {
                    answer[i] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}

