package programmers.summer_winter_coding;

import java.util.*;

public class PGMS_영어_끝말잇기 {

    public static void main(String[] args) {
        PGMS_영어_끝말잇기 pgms_영어_끝말잇기 = new PGMS_영어_끝말잇기();
        String[] words = {"aa", "ab","aa"};
        int[] solution = pgms_영어_끝말잇기.solution(2, words);
        System.out.println(solution[0]);
        System.out.println(solution[1]);
    }

    public int[] solution(int n, String[] words) {

        List<String> history = new ArrayList<>();

        Queue<Pair> q = init(n, words);

        while(!q.isEmpty()){
            Pair poll = q.poll();
            if(q.isEmpty()){
                //마지막 문자의 경우 다르게 처리
                if(history.contains(poll.word))
                    return packaging(poll.who, poll.cnt);
                break;
            }
            //본인 문젠지 판단
            if(isCurrentWordHasMatter(history, poll.word))
                return packaging(poll.who, poll.cnt);

            //뒷사람이 문젠지 판단
            if(isNextWordHasMatter(poll.word, q.peek().word))
                return packaging(q.peek().who, q.peek().cnt);


            history.add(poll.word);
        }

        return packaging(0, 0);
    }

    private boolean isCurrentWordHasMatter(List<String> history, String word){
        return history.contains(word);
    }

    private boolean isNextWordHasMatter(String current, String next){
        return current.charAt(current.length()-1) != next.charAt(0);
    }

    private int[] packaging(int num, int order){
        return new int[] {num, order};
    }

    private Queue<Pair> init(int n, String[] words){
        Queue<Pair> q = new LinkedList<>();

        int i = 1, cnt = 1;
        for(String word: words){
            if(i > n) {
                i = 1;
                cnt++;
            }
            q.add(new Pair(word, i++, cnt));
        }
        return q;
    }

    private static class Pair{
        String word;
        int who;
        int cnt;

        public Pair(String word, int who, int cnt) {
            this.word = word;
            this.who = who;
            this.cnt = cnt;
        }
    }
}
