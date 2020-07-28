package programmers.level3;

import java.util.*;

public class Level3_이중우선순위큐 {
    public static void main(String[] args) {
        Level3_이중우선순위큐 level3_이중우선순위큐 = new Level3_이중우선순위큐();
        String[] operations = {"I 3", "I 3", "D -1", "I 3"};
        System.out.println(level3_이중우선순위큐.solution(operations));
    }

    public int[] solution(String[] operations) {
        List<Integer> pq = new LinkedList<>();

        for(String operation : operations){
            String[] str = operation.split(" ");

            if(str[0].equals("I")){
                pq.add(Integer.valueOf(str[1]));
                Collections.sort(pq);

            }else if(str[0].equals("D")){
                if(pq.isEmpty())
                    continue;

                if(str[1].equals("1")){
                    pq.remove(pq.size()-1);
                }else if(str[1].equals("-1")){
                    pq.remove(0);
                }
            }
        }

        if(pq.isEmpty()){
            return new int[] {0,0};
        }

        return new int[] {pq.get(pq.size()-1), pq.get(0)};
    }

}
