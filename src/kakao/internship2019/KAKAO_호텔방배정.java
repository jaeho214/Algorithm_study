package kakao.internship2019;

import java.util.*;

public class KAKAO_호텔방배정 {
    public static void main(String[] args) {
        KAKAO_호텔방배정 kakao_호텔방배정 = new KAKAO_호텔방배정();
        long[] room_number = {1,3,4,1,3,1};
        System.out.println(kakao_호텔방배정.solution(1000000000, room_number));
    }
    //현재 배정된 방 목록
    static Set<Long> rooms;
    //비어있는 방 목록
    static TreeSet<Long> empty_room;
    public long[] solution(long k, long[] room_number) {
        rooms = new HashSet<>();
        empty_room = new TreeSet<>();

        long[] answer = new long[room_number.length];
        int idx = 0;
        for(long room : room_number){
            answer[idx++] = findRoom(room);
        }
        return answer;
    }


    public static long findRoom(long num) {
        //그 방이 배정된 경우
        if(rooms.contains(num))
            //빈 방을 타고 올라가면서 배정할 방을 찾는다.
            return findRoom(empty_room.higher(num));

        //배정이 안되어있는 경우 방 배정
        rooms.add(num);
        //빈 방에서 제거
        empty_room.remove(num);

        //배정된 방의 다음 방이 배정이 안되어 있는 경우
        if(!rooms.contains(num+1))
            //빈 방으로 등록
            empty_room.add(num+1);

        return num;
    }

    /*
     * 정확도 : 78.8
     * 효율성 : 12.1
     * 합계 : 90.9 / 100.0
     */
    public long[] solution2(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        Map<Long, Long> room_map = new LinkedHashMap<>();
        for(long room : room_number) {
            if (!room_map.containsKey(room)) {
                room_map.put(room, room + 1);
                continue;
            }
            Long next = room_map.get(room);
            while (next <= k) {
                if (room_map.containsKey(next)) {
                    next = room_map.get(next);
                    continue;
                }
                room_map.put(next, next + 1);
                room_map.put(room, next + 1);
                break;
            }

        }
        List<Long> tmp = new ArrayList<>();
        for(Long key : room_map.keySet()){
            tmp.add(key);
        }
        for(int i=0;i<tmp.size();i++){
            answer[i] = tmp.get(i);
        }
        return answer;
    }
}
