package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


/*
 * n : 회의의 개수
 * i : 회의들의 시작시간과 종료시간이 담긴 배열
 * 겹치기 않게 회의할 수 있는 최대값 찾기
 */

public class BOJ_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int buffer = 0;
        int sum = 0,fakeSum = 0;
        int i[][] = new int[n][2];

        for(int j=0;j<n;j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            i[j][0] = Integer.parseInt(st.nextToken());
            i[j][1] = Integer.parseInt(st.nextToken());

        }

        Arrays.sort(i, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });

        for(int j=0;j<n;j++) {
            if(buffer <= i[j][0]) {
                buffer = i[j][1];
                fakeSum++;
            }
        }
        if(fakeSum > sum) {
            sum = fakeSum;
        }


        System.out.println(sum);

    }
}
