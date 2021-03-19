package kakao.blind2021;

import java.util.*;

public class PGMS_순위검색_23점 {
    public static void main(String[] args) {
        PGMS_순위검색_23점 pgms_순위검색23점 = new PGMS_순위검색_23점();
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        System.out.println(pgms_순위검색23점.solution(info, query));
    }

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        Map<String, List<Integer>> map = new HashMap<>();

        for(int i=0; i<info.length; i++) {
            dfs(info[i].split(" "), 0, "", map);
        }

        for(String key : map.keySet()) {
            Collections.sort(map.get(key));
            map.put(key,map.get(key));
        }

        for(int i=0; i<query.length; i++) {
            String[] split = query[i].split(" and ");
            String[] s = split[3].split(" ");
            String value = split[0] + split[1] + split[2] + s[0];

            for(String key : map.keySet()) {
                if(!value.equals(key)) continue;

                int index = lowerBound(map.get(key), Integer.parseInt(s[1]));
                answer[i] = map.get(key).size() - index;
            }
        }

        return answer;
    }

    public void dfs(String[] info, int index, String result, Map<String, List<Integer>> map) {

        if(index == 4) {
            if(!map.containsKey(result)) map.put(result, new ArrayList<>(Arrays.asList(Integer.parseInt(info[4]))));
            else {
                List<Integer> temp = map.get(result);
                temp.add(Integer.parseInt(info[4]));
                map.put(result, temp);
            }
            return;
        }

        dfs(info, index+1, result+"-", map);
        dfs(info, index+1, result + info[index], map);
    }

    public int lowerBound(List<Integer> data, int target) {
        int left = 0;

        int right = data.size();

        while(left < right) {
            int mid = (left + right) / 2;

            if(data.get(mid) >= target) right = mid;
            else left = mid + 1;

        }

        return right;
    }

}
