package programmers.level1;

import java.util.Arrays;
import java.util.Collections;

public class Level1_1 {
    public static void main(String[] args) {
        Level1_1 level1_1 = new Level1_1();
        System.out.println(level1_1.solution(118372));
    }

    public long solution(long n) {
        String str = String.valueOf(n);
        Character[] arr = new Character[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }

        Arrays.sort(arr, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i]);
        }

        return Long.parseLong(sb.toString());
    }
}
