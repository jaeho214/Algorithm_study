package programmers.level3;

public class Level3_기지국설치 {
    public static void main(String[] args) {
        Level3_기지국설치 level3_기지국설치 = new Level3_기지국설치();
        int[] stations = {9};
        System.out.println(level3_기지국설치.solution(16, stations, 2));
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0;
        int apartIdx = 1;

        while(apartIdx <= n){
            if(stationIdx < stations.length && apartIdx >= stations[stationIdx] - w){
                apartIdx = stations[stationIdx]+w+1;
                stationIdx++;
            }else{
                answer++;
                apartIdx += (w*2)+1;
            }
        }


        return answer;
    }
}
