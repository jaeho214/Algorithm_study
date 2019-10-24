package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * N : 여학생의 수
 * M : 남학생의 수
 * K : 인턴쉽에 참여하는 학생의 수
 * 여학생 2, 남학생 1로 구성된 대회 팀의 최대수를 구하는 문제(인터쉽에 참여하면 대회에 나갈 수 없음)
 * 여학생의 수에서 최대로 나갈 수 있는 팀 숫자를 구한 후 남학생 수와 비교하여 팀 숫자 조정, 후에 인턴쉽에 나가는 학생들을 고려하여 팀 숫자 재조정
 */
public class BOJ_2875_대회or인턴 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 여학생 수
        int M = Integer.parseInt(st.nextToken()); // 남학생 수
        int K = Integer.parseInt(st.nextToken()); // 인턴쉽에 참여할 학생 수
        int max = N/2, team = 0, sum = N+M-K;

        if(M<=max) {
            max = M;
        }
        team = max * 2 + max * 1;
        while(sum < team) {
            team -= 3;
            max--;
        }

        System.out.println(max);


    }
}
