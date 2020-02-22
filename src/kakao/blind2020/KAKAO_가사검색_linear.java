package kakao.blind2020;

/*
 * 정확성 : 25.0
 * 효율성 : 30.0
 * 전체  : 55/100
 */
public class KAKAO_가사검색_linear {
    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        KAKAO_가사검색_linear kakao_가사검색 = new KAKAO_가사검색_linear();
        System.out.println(kakao_가사검색.solution(words,queries));
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i=0; i<queries.length; i++){
            StringBuilder sb = new StringBuilder();

            int idx = 0;
            if(queries[i].startsWith("?")){
                for(int j=queries[i].lastIndexOf("?")+1;j<queries[i].length();j++){
                    sb.append(queries[i].charAt(j));
                }
                idx = 0;
            }else if(queries[i].endsWith("?")){
                for(int j=0;j<queries[i].indexOf("?");j++){
                    sb.append(queries[i].charAt(j));
                }
                idx = 1;
            }

            if(idx == 0){ //뒤가 같은지 확인
                for(int j=0;j<words.length;j++){
                    if (words[j].endsWith(sb.toString()) && words[j].length() == queries[i].length()){
                        answer[i]++;
                    }
                }
            }else if(idx == 1){
                for(int j=0;j<words.length;j++){
                    if(words[j].startsWith(sb.toString()) && words[j].length() == queries[i].length()){
                        answer[i] ++;
                    }
                }
            }
        }
        return answer;
    }

}
