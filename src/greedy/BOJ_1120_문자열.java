package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * A : A 문자열
 * B : B 문자열
 * A의 앞이나 뒤에 문자열을 삽입하여 B문자열과의 차이가 최소값이 나오는 문제
 * A문자열의 앞에 공백을 하나씩 추가하며 B문자열과 비교하는 방식으로 처리(A문자열의 앞,뒤에 둘다 삽입될 수 있기 때문)
 */
public class BOJ_1120_문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String A = st.nextToken();
        String B = st.nextToken();
        int result = 50, min = 0;
        int num = B.length()-A.length();

        for(int i=0;i<=num;i++) {
            min = 0;
            for(int j=i;j<A.length();j++) {
                if(A.charAt(j)!=B.charAt(j)) {
                    min++;
                }
            }
            if(result > min) {
                result = min;
            }
            A = " " + A.substring(0, A.length());
        }

        System.out.println(result);
    }
}
