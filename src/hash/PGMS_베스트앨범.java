package hash;

import java.util.*;

public class PGMS_베스트앨범 {
    public class Album{
        String genre;
        int plays;
        int index;

        public Album(String genre, int plays, int index) {
            this.genre = genre;
            this.plays = plays;
            this.index = index;
        }
    }
    public static void main(String[] args) {
        String[] genres = {"classic", "pop","classic","classic", "pop"};
        int[] plays = {500,600,150,800,2500};
        PGMS_베스트앨범 pgms_베스트앨범 = new PGMS_베스트앨범();
        int[] solution = pgms_베스트앨범.solution(genres, plays);
        for(int i : solution)
            System.out.print(i + " ");
    }


    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        List<Album> list = new ArrayList<>();
        List<Album> copy = new ArrayList<>();
        HashMap<String, Integer> morePlayMap = new HashMap<>();
        HashMap<String, Integer> genreCountMap = new HashMap<>();

        for(int i=0;i<genres.length;i++){
            list.add(new Album(genres[i], plays[i], i));
            morePlayMap.put(genres[i], morePlayMap.getOrDefault(genres[i], 0) + plays[i]);
            genreCountMap.put(genres[i], genreCountMap.getOrDefault(genres[i], 0) + 1);
            if(genreCountMap.get(genres[i]) > 2)
                genreCountMap.put(genres[i], 2);
        }

        Collections.sort(list, (o1, o2) -> {
            if(o1.plays < o2.plays)
                return 1;
            return -1;
        });

        for(Album a : list){
            if(genreCountMap.get(a.genre) < 1)
                continue;
            else{
                genreCountMap.put(a.genre, genreCountMap.getOrDefault(a.genre, 0) - 1);
                copy.add(a);
            }
        }

        Collections.sort(copy, (o1, o2) -> {
            if(morePlayMap.get(o1.genre) < morePlayMap.get(o2.genre))
                return 1;
            return -1;
        });

        for(int i=1;i<copy.size();i++){
            if(copy.get(i-1).genre.equals(copy.get(i).genre)){
                if(copy.get(i-1).plays < copy.get(i).plays){
                    Collections.swap(copy, i-1, i);
                }
            }
        }
        answer = new int[copy.size()];
        for(int i=0;i<copy.size();i++){
            answer[i] = copy.get(i).index;
        }



        return answer;
    }
}
