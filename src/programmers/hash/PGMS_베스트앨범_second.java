package programmers.hash;

import java.util.*;

public class PGMS_베스트앨범_second {
    public static void main(String[] args) {
        PGMS_베스트앨범_second pgms_베스트앨범_second = new PGMS_베스트앨범_second();
        String[] genres = {"classic", "classic", "classic", "pop"};
        int[] plays = {500,150,800,2500};
        System.out.println(pgms_베스트앨범_second.solution(genres, plays));
    }

    public class Music implements Comparable<Music>{
        private int num;
        private String genre;
        private int plays;

        public Music(int num, String genre, int plays) {
            this.num = num;
            this.genre = genre;
            this.plays = plays;
        }

        @Override
        public int compareTo(Music o) {
            if(this.genre.compareTo(o.genre) > 0){
                return 1;
            }else if(this.genre.compareTo(o.genre) < 0){
                return -1;
            }else{
                if(this.plays > o.plays)
                    return -1;
                else if(this.plays < o.plays)
                    return 1;
                else{
                    if(this.num > o.num)
                        return 1;
                    else if(this.num < o.num)
                        return -1;
                    else
                        return 0;
                }
            }
        }
    }

    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        List<Integer> result = new ArrayList<>();
        Map<String, Integer> allMusics = new LinkedHashMap<>();
        List<Music> list = new ArrayList<>();

        for(int i=0;i<genres.length;i++){
            allMusics.put(genres[i], allMusics.getOrDefault(genres[i], 0) + plays[i]);
            list.add(new Music(i, genres[i], plays[i]));
        }
        list.sort(Music::compareTo);
        Map<String, Integer> musicMap = sortByValue(allMusics);
        Iterator<String> iterator = musicMap.keySet().iterator();

        while(iterator.hasNext()){
            String next = iterator.next();
            int cnt = 0;
            for(Music m : list){
                if(m.genre.equals(next) && cnt<2){
                    cnt++;
                    result.add(m.num);
                }
            }
        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++){
            answer[i] = result.get(i);
        }


        return answer;
    }

    public Map<String, Integer> sortByValue(final Map map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list, (o1, o2) -> {
            int comparision = (o1.getValue() - o2.getValue()) * -1;
            return comparision == 0 ? o1.getKey().compareTo(o2.getKey()) : comparision;
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Iterator<Map.Entry<String, Integer>> iter = list.iterator(); iter.hasNext();){
            Map.Entry<String, Integer> entry = iter.next();
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


}
