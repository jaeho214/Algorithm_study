package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * N : 입력 숫자
 * 숫자를 입력하여 그 숫자의 각 자리수를 조합하여 30의 배수가 나오면 그 배수로, 없다면 -1로 출력
 * 30의 배수이므로 무조건 0이 포함이 되어있어야 하고 나머지 숫자들의 합이 3이 나와야 30의 배수로 성립
 */

public class BOJ_10610_30 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int[] num = new int[N.length()];
        int sum = 0;

        for(int i=0;i<N.length();i++) {
            sum += Integer.parseInt(N.charAt(i)+"");
            num[i] = Integer.parseInt(N.charAt(i)+"");
        }

        if(N.contains("0") && sum % 3 == 0) {
            Arrays.sort(num);
            reverseArrayInt(num);
            for(int i : num) {
                System.out.print(i);
            }
        }else
            System.out.println("-1");


    }
    public static void reverseArrayInt(int[] arr) {
        int temp;

        for(int i=0;i<arr.length/2;i++) {
            temp = arr[i];
            arr[i] = arr[(arr.length-1) -i];
            arr[(arr.length-1) -i] = temp;
        }
    }

}
