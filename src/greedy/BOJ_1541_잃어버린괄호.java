package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 *
 * -이후 부터 다음 -가 나올때까지 괄호를 쳐주는게 최소값이 나오는 방법이라고 판단.
 * -와 -사이의 모든 값들을 더해주고 계산을 하면 큰 숫자를 뺄 수 있기 때문
 * -를 기준으로 split하고 모든 값들을 빼줬다.
 */
public class BOJ_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("\\-");

        int result = 0;

        for(int i=0;i<input.length;i++) {
            int calc = calc(input[i]);

            if(i==0)
                result = calc;
            else
                result -= calc;
        }

        System.out.println(result);
    }

    public static int calc(String number) {
        String[] plus = number.split("\\+");
        int result = 0;

        for(String i : plus) {
            result += Integer.parseInt(i);
        }

        return result;
    }
}


