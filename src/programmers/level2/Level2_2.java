package programmers.level2;
/*
 * https://www.youtube.com/watch?v=HFnyxCQe_2g
 */
public class Level2_2 {
    public static void main(String[] args) {
        Level2_2 level2_2 = new Level2_2();
        System.out.println(level2_2.solution("abcabcabcabcdededededede"));
    }

    public int solution(String s) {
        int answer = s.length();

        for(int i=1;i<=s.length()/2; i++){
            //idx 부터 i 만큼 가면서 자를거임
            //i가 1이면 하나씩 2면 두개씩
            int idx = 0;
            //일단 주어진 문자열의 길이로 초기화
            int len = s.length();

            //맨처음 문자열부터 탐색하면서
            while(i+idx <= s.length()){
                //맨 처음 문자열 꺼내고
                String str = s.substring(idx, idx + i);
                //idx 를 i만큼 증가
                idx += i;

                int cnt = 0;
                //그 이후를 돌면서
                while(i+idx <= s.length()){
                    //같은게 있으면 카운트
                    if(str.equals(s.substring(idx, idx + i))){
                        cnt++;
                        idx += i;
                    //다르면 브레이크
                    //앞에서 부터 자르기 때문에 break로 멈춰버림
                    }else{
                        break;
                    }
                }
                //중복되는 것들이 있으면
                if(cnt >0){
                    //중복되는 문자열의 길이와 중복된 개수를 곱하여 len에서 빼준다
                    //abababab(ab * 4 = 8) -> ab(2), cnt=4 -> 4ab(1 + ab = 3)
                    len -= i * cnt;

                    //그리고 여기서 cnt의 개수에 따라 두자리 숫자냐 세자리 숫자냐에 따라서
                    //len에 숫자의 길이를 더해준다.
                    if(cnt < 9) len += 1;
                    else if(cnt < 99) len += 2;
                    else if(cnt < 999) len += 3;
                    else len += 4;

                }
            }
            answer = Math.min(answer, len);
        }
        return answer;
    }

}
