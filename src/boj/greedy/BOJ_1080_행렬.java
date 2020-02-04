package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 0과 1로만 이루어진 행렬 A와 행렬 B가 있다. 이때, 행렬 A를 행렬 B로 바꾸는데 필요한 연산의 횟수의 최솟값을 구하는 프로그램을 작성하시오.
 * 행렬을 변환하는 연산은 어떤 3*3크기의 부분 행렬에 있는 모든 원소를 뒤집는 것이다. (0 -> 1, 1 -> 0)
 *
 * A행렬만을 받아서 B행렬과의 차이만 check 배열에 넣어주었다.
 * A행렬과 B행렬이 다를때만 연산을 진행한다. 3x3 행렬만 연산을 진행할 수 있기 때문에 행과 열의 마지막 두 칸은 따로 조건을 넣어 확인해준다.
 * A행렬과 B행렬이 다를때만 연산을 하고 cnt를 세서 그대로 출력한다.
 */
public class BOJ_1080_행렬 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] array = new char[N][M];
        boolean[][] check = new boolean[N][M];

        for(int i=0;i<N;i++)
            array[i] = br.readLine().toCharArray();

        int diff=0;
        for(int i=0;i<N;i++) {
            char[] inputs = br.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                if(inputs[j] != array[i][j]) {
                    check[i][j] = true;
                    diff++;
                }
            }
        }

        if(diff == 0)
            System.out.println(0);
        else
            System.out.println(solution(check));

    }

    public static int solution(boolean[][] check) {
        int n = check.length;
        int m = check[0].length;

        if(n<3 || m<3)
            return -1;

        int count = 0;
        for(int i=0;i<=n-3;i++) {
            for(int j=0;j<=m-3;j++) {
                if(i==n-3 && !(check[i][j] == check[i+1][j] && check[i][j] == check[i+2][j]))
                    return -1;
                if(j==m-3 && !(check[i][j] == check[i][j + 1] && check[i][j] == check[i][j + 2]))
                    return -1;

                if(check[i][j]) {
                    operation(i, j, check);
                    count ++;
                }
            }
        }
        boolean flag = check[n-3][m-3];
        for (int i = n - 1; i > n - 3; i--) {
            for (int j = m - 1; j > m - 3; j--) {
                if (flag != check[i][j])
                    return -1;
            }
        }
        return count;

    }

    public static void operation(int num1, int num2, boolean[][] check) {
        for(int i=num1;i<num1+3;i++) {
            for(int j=num2;j<num2+3;j++) {
                check[i][j] = !check[i][j];

            }
        }
    }
}
