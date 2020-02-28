package kakao.blind2019;

import java.util.*;
/*
 * https://dundung.tistory.com/124
 * 비트마스크에 대해 알게 되었다. 너무 어렵다.
 */
public class KAKAO_후보키_DFS_BIT {
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) {
        String[][] relation = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},
                {"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        KAKAO_후보키_DFS_BIT kakao_후보키DFSBIT = new KAKAO_후보키_DFS_BIT();
        System.out.println(kakao_후보키DFSBIT.solution(relation));
    }

    public int solution(String[][] relation) {
        //dfs를 통해 모든 가능성들을 찾는다
        dfs(relation, "", -1);
        int answer = 0;
        //최소성을 찾기위해 작은 것부터 확인
        Collections.sort(list);
        while(!list.isEmpty()){
            int v = list.remove(0);
            answer++;
            Iterator<Integer> iterator = list.iterator();
            while(iterator.hasNext()){
                int next = iterator.next();
                //포함하는게 있다면
                //즉, v는 1000이고 next 가 1001 이면 네번째 자리가 다르므로 불가
                //(next&v) == v 는 다른 비트가 하나도 없을 때 성립
                if((next&v) == v)
                    iterator.remove();
            }
        }
        return answer;
    }

    //String 을 relation 의 값들이 아니라 컬럼의 개수로 한다 ex)0123 은 4개의 컬럼이 유일성을 만족한다는 얘기
    private void dfs(String[][] relation, String str, int cnt) {
        if(cnt == relation[0].length-1){
            //유일성을 만족하면
            if(check(relation, str)){
                int current = 0;
                //비트를 계산하는 로직
                for(int i=0;i< str.length();i++){
                    //비트를 계산한다. 0123은 4개의 컬럼이 유일성을 만족한다는 얘기고
                    //0123은 2^0 + 2^1 + 2^2 + 2^3 하여 current 가 15가 되고
                    //01은 2^0 + 2^1 하여 current 가 3이 된다.
                    //13은 2^1 + 2^3 하여 10이 된다.
                    current += 1<<(str.charAt(i)-'0');
                }
                //가능한 경우의 수들을 10진수로 바꿔서 list에 저장
                list.add(current);
            }
            return;
        }
        dfs(relation, str+(cnt+1), cnt+1);
        dfs(relation, str, cnt+1);
    }

    //유일성 만족 여부를 판단하는 메소드
    private boolean check(String[][] relation, String str) {
        Set<String> set = new TreeSet<>();
        for(int i=0;i<relation.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<str.length();j++){
                sb.append(relation[i][str.charAt(j)-'0']);
            }
            set.add(sb.toString());
        }
        if(set.size() == relation.length)
            return true;
        return false;
    }
}
