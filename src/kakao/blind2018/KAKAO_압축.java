package kakao.blind2018;

import java.util.*;

public class KAKAO_압축 {
    public static void main(String[] args) {
        KAKAO_압축 kakao_압축 = new KAKAO_압축();
        System.out.println(kakao_압축.solution("TOBEORNOTTOBEORTOBEORNOT"));
    }

    public int[] solution(String msg) {
        int[] answer = {};
        int idx = 27;
        Map<String, Integer> dictionary = init();
        List<Integer> resultList = new ArrayList<>();
        Queue<String> msgQ = new LinkedList<>();
        for(int i=0;i<msg.length();i++)
            msgQ.add(String.valueOf(msg.charAt(i)));

        String current = "";
        while(!msgQ.isEmpty()){
            //일단 큐에서 하나 꺼내보고
            current += msgQ.peek();
            //있어?
            if(dictionary.containsKey(current)) {
                //그럼 큐에서 빼
                msgQ.poll();
            //없어?
            }else{
                //그럼 바로 전 문자열을 사전에서 꺼내고
                resultList.add(dictionary.get(current.substring(0, current.length()-1)));
                //현재 문자열을 사전에 넣어줘
                dictionary.put(current, idx++);
                current = "";
            }
        }
        //마지막 남은 문자열은 사전에 있으면 결과에 넣어줘
        if(dictionary.containsKey(current))
            resultList.add(dictionary.get(current));

        answer = new int[resultList.size()];
        for(int i=0;i<resultList.size();i++){
            answer[i] = resultList.get(i);
        }

        return answer;
    }


    public Map<String, Integer> init(){
        Map<String, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<26;i++){
            map.put(String.valueOf((char)(65+i)), i+1);
        }
        return map;
    }
}
