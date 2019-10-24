package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 언제나 최고만을 지향하는 굴지의 대기업 진영 주식회사가 신규 사원 채용을 실시한다.
 * 인재 선발 시험은 1차 서류심사와 2차 면접시험으로 이루어진다.
 * 최고만을 지향한다는 기업의 이념에 따라 그들은 최고의 인재들만을 사원으로 선발하고 싶어 한다.
 * 그래서 진영 주식회사는, 다른 모든 지원자와 비교했을 때 서류심사 성적과 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지지 않는 자만 선발한다는 원칙을 세웠다.
 * 즉, 어떤 지원자 A의 성적이 다른 어떤 지원자 B의 성적에 비해 서류 심사 결과와 면접 성적이 모두 떨어진다면 A는 결코 선발되지 않는다.이러한 조건을 만족시키면서,
 * 진영 주식회사가 이번 신규 사원 채용에서 선발할 수 있는 신입사원의 최대 인원수를 구하는 프로그램을 작성하시오.
 *
 *서류등수를 정렬 -> 서류 1등의 면접 점수를 max에 저장 -> 서류 등수 순서대로 내려가면서 면접 등수가 max보다 낮으면 불가능, 높으면 max에다가 값을 넣어주기
 *이중 포문을 사용해서 O(n*2) 에서 max 변수를 사용함으로써 O(n)으로 수정할 수 있었음
 */
public class BOJ_1946_신입사원 {
    static int T = 0;
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        int N =0;
        int[][] rank = {};
        int[] result = new int[T];

        for(int i=0;i<T;i++) {
            N = Integer.parseInt(br.readLine());
            rank = new int[N][2];

            for(int j=0;j<N;j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }
            result[i] = solution(rank, N);
        }

        //output
        for(int i=0;i<T;i++) {
            System.out.println(result[i]);
        }
    }

    public static int solution(int[][] rank, int N) {
        boolean[] status = new boolean[N];
        int result = 0;

        for(int i=0;i<N;i++) {
            status[i] = true;
        }

        Arrays.sort(rank, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        int max = rank[0][1];

        for(int i=1;i<N;i++) {
            if(max < rank[i][1]) {
                status[i] = false;
            }else {
                max = rank[i][1];
            }
        }

        for(int i=0;i<N;i++) {
            if(status[i] == true)
                result++;
        }

        return result;
    }
}


