package bfs_dfs;
/*
 * https://artineer.tistory.com/123
 */
public class PGMS_단어변환 {
    static int min=0;
    static String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
    public static void main(String[] args) {
        solution("hit", "cog", words);
        System.out.println(min);
    }

    private static int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length+1];
        dfs(begin, target, words, 0, visited);
        return min;
    }

    private static void dfs(String begin, String target, String[] words, int num, boolean[] visited) {
        //target 값이랑 같으면
        if(begin.equals(target))
            //그때의 num(횟수)를 min 에 저장
            min = (min == 0) ? num : Math.min(min, num);

        for(int i=0;i<words.length;i++){
            if(begin.equals(words[i]))
                continue;
            //방문하지 않은 인덱스이고 한 글짜 빼고 모두 같으면
            if(!visited[i] && hasOneCharDif(begin,words[i])){
                //방문 처리 후
                visited[i] = true;
                //dfs
                dfs(words[i], target, words, num + 1, visited);
                //dfs 후 방문 취소(백트래킹)
                visited[i] = false;
            }
        }
        return ;
    }

    //문자의 길이가 길 수도 있다는 생각을 안하고 그냥 같은 문자의 개수가 2일때만 처리함
    private static  boolean hasOneCharDif ( String str1, String str2 ) {
        int len = str1.length();
        int cnt = 0;
        for ( int i=0; i<len; i++ ) {
            if ( str1.charAt(i) != str2.charAt(i) ) {
                cnt++;
                if ( cnt > 1) {
                    cnt = 0;
                    break;
                }
            }
        }
        if ( cnt == 1 ) return true;
        return false;
    }
}
