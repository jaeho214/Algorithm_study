package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
 * num : ATM에서 인출할 사람들의 수
 * times : 사람들이 돈을 인출하는 데에 걸리는 시간들의 배열
 * ATM기 에서 돈을 인출하는 데에 필요한 시간의 합의 최소값구하기
 */

public class BOJ_11399_ATM {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        int times[] = new int[num+1];
        int temp=0;
        int result = 0;
        int sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<num;i++) {
            times[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<num;i++) {
            for(int j=0;j<num-1;j++) {
                if(times[j] > times[j+1]) {
                    temp = times[j+1];
                    times[j+1] = times[j];
                    times[j] = temp;
                }
            }

        }

        for (int i=0;i<num;i++) {
            result += times[i] + sum;
            sum += times[i];
        }

        System.out.println(result);

    }

}
