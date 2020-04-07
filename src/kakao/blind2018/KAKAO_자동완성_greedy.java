package kakao.blind2018;

import java.util.Arrays;

public class KAKAO_자동완성_greedy {

    public static void main(String[] args) {
        KAKAO_자동완성_greedy kakao_자동완성Greedy = new KAKAO_자동완성_greedy();
        String[] words = {"word", "war", "warrior", "world"};
        System.out.println(kakao_자동완성Greedy.solution(words));
    }

    public int solution(String[] words) {
        int answer = 0;

        //알파벳 순으로 정렬 후
        Arrays.sort(words);

        for(int i = 0 ; i < words.length ; i++) {
            for(int j = 1 ; j < words[i].length() ; j++) {
                //첫 번째일 경우 두번째 문자와
                if (i == 0) {
                    if (words[i + 1].startsWith(words[i].substring(0, j))) answer++;
                    else break;
                //마지막일 경우 그 앞의 문자와
                } else if (i == words.length - 1) {
                    if (words[i - 1].startsWith(words[i].substring(0, j))) answer++;
                    else break;
                //첫번째도 마지막도 아닐경우에는 앞뒤 문자와 비교하여 cnt
                } else {
                    if (words[i + 1].startsWith(words[i].substring(0, j))
                            || words[i - 1].startsWith(words[i].substring(0, j))) answer++;
                    else break;
                }
            }
            answer++;
        }
        return answer;
    }



}
