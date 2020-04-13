package programmers.summer_winter_coding;

public class PGMS_기지국설치 {
    public static void main(String[] args) {
        PGMS_기지국설치 pgms_기지국설치 = new PGMS_기지국설치();
        int[] stations = {4,9,14};
        System.out.println(pgms_기지국설치.solution(16, stations, 2));
    }
    /*
     * n : 아파트 개수
     * stations : 설치된 기지국의 위치
     * w : 기지국의 전파 범위
     */
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        //stations를 살피기 위한 인덱스
        int idx = 0;
        //아파트를 살피기 위한 인덱스
        int pos = 1;

        //1번부터 n까지 살핀다.
        while(pos <= n){
            // 기지국이 설치되어 전파를 받는 곳이라면
            if(idx < stations.length && pos >= stations[idx] - w){
                //pos를 기지국의 오른쪽에서 전파를 받지 못하는 곳으로 옮기고
                pos = stations[idx] + w + 1;
                //다음 기지국을 확인하기 위해 idx ++
                idx++;
            }
            // 전파를 받지 못하는 곳이라면
            else{
                //기지국을 설치하고
                answer ++;
                //기지국의 오른쪽에서 전파를 받지 못하는 곳으로 이동
                pos += (w*2) + 1;
            }
        }
        return answer;
    }
}
