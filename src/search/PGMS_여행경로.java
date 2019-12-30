package search;

import java.util.*;
/*
 * https://youjourney.tistory.com/111
 * 백트래킹을 사용해야했다. 계속 테스트 케이스 1번에서 오류가 나서 풀지 못하였다,,
 */
public class PGMS_여행경로 {
    static boolean visited[];
    static List<String> list = new ArrayList<>();
    static String route = "";
    public static void main(String[] args) {
        String[][] tickets = { { "ICN", "SFO" }, { "ICN", "ATL" },{ "SFO", "ATL"}, { "ATL", "ICN"}, { "ATL", "SFO"}};
        String[] res = solution(tickets);
        for(String str : res)
            System.out.print(str + " ");
    }
    public static String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String destination = tickets[i][1];

            //출발지가 ICN 이면
            if(start.equals("ICN")){
                //방문처리 하고
                visited[i] = true;
                // 루트에 ICN 를 추가한 후에
                route = start + ",";
                //dfs 시작
                dfs(tickets, destination, 1);
                //백트래킹
                visited[i] = false;
            }
        }
        //알파벳으로 오름차순
        Collections.sort(list);
        //리스트를 배열로
        answer = list.get(0).split(",");
        return answer;
    }


    private static void dfs(String[][] tickets, String end, int count) {
        //루트에 도착지를 추가
        route += end + ",";
        //모든 항공권을 사용하면 루트 리스트에 루트를 추가하고 return
        if(count == tickets.length){
            list.add(route);
            return;
        }

        for(int i=0;i<tickets.length;i++){
            String start = tickets[i][0];
            String destination = tickets[i][1];

            //현재 도착지가 배열에서 출발지와 동일할 때
            if(end.equals(start) && !visited[i]){
                //방문 처리를 하고
                visited[i] = true;
                //다시 dfs
                dfs(tickets, destination, count+1);
                visited[i] = false;
                //dfs 가 끝나면 다른 루트를 제거하기 위해 뒤에서부터 하나씩 지워나감
                route = route.substring(0,route.length()-4);
            }
        }
    }


}
