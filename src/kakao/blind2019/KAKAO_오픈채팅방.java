package kakao.blind2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KAKAO_오픈채팅방 {

    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        KAKAO_오픈채팅방 kakao_오픈채팅방 = new KAKAO_오픈채팅방();
        System.out.println(kakao_오픈채팅방.solution(record));
    }

    public String[] solution(String[] record) {
        List<String> answer = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        for(String str : record){
            String[] sArray = str.split(" ");
            if(sArray[0].equals("Leave"))
                continue;
            map.put(sArray[1], sArray[2]);
        }

        for(String str : record){

            String[] sArray = str.split(" ");
            if(sArray[0].equals("Enter")){
                answer.add(map.get(sArray[1])+"님이 들어왔습니다.");
            }else if(sArray[0].equals("Leave")){
                answer.add(map.get(sArray[1])+"님이 나갔습니다.");
            }
        }

        String[] res = new String[answer.size()];
        for(int i=0;i<answer.size();i++){
            res[i] = answer.get(i);
        }
        return res;
    }
}
