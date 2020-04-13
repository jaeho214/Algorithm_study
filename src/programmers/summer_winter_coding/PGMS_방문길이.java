package programmers.summer_winter_coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PGMS_방문길이 {
    public static void main(String[] args) {
        PGMS_방문길이 pgms_방문길이 = new PGMS_방문길이();
        System.out.println(pgms_방문길이.solution("ULURRDLLU"));
    }
    public class Pair{
        //이동한 좌표가 x 인지 y 인지
        String s;
        // x가 이동 했을 경우 y의 위치 or y가 이동 했을 경우 x의 위치
        int pos;
        // s가 어디서
        int from;
        // 어디로 이동 했는지
        int to;

        public Pair(String s, int pos, int from, int to) {
            this.s = s;
            this.pos = pos;
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            if(s.equals(pair.s) &&
                    pos == pair.pos &&
                    ((from == pair.from && to == pair.to) || (from == pair.to && to == pair.from)))
                return true;
            return from == pair.from &&
                    to == pair.to &&
                    pos == pair.pos &&
                    s.equals(pair.s);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, pos, from, to);
        }
    }

    public int solution(String dirs) {
        int answer = 0;

        List<Pair> list = new ArrayList<>();

        int x = 0, y = 0;
        for(char ch : dirs.toCharArray()){
            int before = 0, current = 0, pos = 0;
            StringBuilder sb = new StringBuilder();
            if(ch == 'U'){
                if(y<5) {
                    before = y;
                    y++;
                    current = y;
                    pos = x;
                    sb.append("y");
                }else
                    continue;
            }else if(ch == 'D'){
                if(y>-5) {
                    before = y;
                    y--;
                    current = y;
                    pos = x;
                    sb.append("y");
                }else
                    continue;
            }else if(ch == 'L'){
                if(x>-5) {
                    before = x;
                    x--;
                    current = x;
                    pos = y;
                    sb.append("x");
                }else
                    continue;
            }else if(ch == 'R'){
                if(x<5) {
                    before = x;
                    x++;
                    current = x;
                    pos = y;
                    sb.append("x");
                }else
                    continue;
            }

            Pair pair = new Pair(sb.toString(), pos, before, current);
            if(!list.contains(pair)){
                answer ++;
                list.add(pair);
            }
        }



        return answer;
    }
}
