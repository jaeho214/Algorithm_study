package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * Day Of Mourning의 기타리스트 강토가 사용하는 기타에서 N개의 줄이 끊어졌다.
 * 따라서 새로운 줄을 사거나 교체해야 한다. 강토는 되도록이면 돈을 적게 쓰려고 한다.
 * 6줄 패키지를 살 수도 있고, 1개 또는 그 이상의 줄을 낱개로 살 수도 있다.
 * 끊어진 기타줄의 개수 N과 기타줄 브랜드 M개가 주어지고, 각각의 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때,
 * 적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
 *
 * 끊어진 줄의 개수 N이 패키지 개수인 6과 비교하여 조건을 걸었다.
 * 6보다 작은 경우에는 패키지로 사는 것과 낱개로 사는 것만 비교하면 되었으나
 * 6보다 큰 경우에는 다 패키지로 사는 경우, 패키지와 낱개를 혼합하는 경우, 다 낱개로 사는 경우 세가지를 고려해야 했다.
 * 다 낱개로 사는 경우 가장 쌀 수도 있다는 경우를 제외하는 실수를 범하면서 시간이 걸렸다.
 */
public class BOJ_1049_기타줄 {
    public static void main(String[] args) throws IOException {
        //input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int price[][] = new int[M][2];
        int min = 0;
        for(int i=0;i<M;i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            price[i][0] = Integer.parseInt(st2.nextToken());
            price[i][1] = Integer.parseInt(st2.nextToken());
        }

        //solution
        int oneItem=sort(price,1);
        int packages=sort(price,0);
        if(N<6) {
            min = check(oneItem*N, packages);
        }else {
            min = check(packages*(N/6)+oneItem*(N%6), packages*((N/6)+1));
            min = check(min, oneItem*N); // 낱개로 모두 구매했을 때 싼 경우도 존재했음,, 이 부분을 놓침,,
        }

        //output
        System.out.println(min);
    }

    public static int sort(int[][] price, int num){
        Arrays.sort(price, new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[num]-o2[num];
            }
        });

        return price[0][num];
    }

    public static int check(int first, int second) {
        if(first < second)
            return first;
        else
            return second;
    }
}
