package hackerrank.ict;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Number2 {
    public static void main(String[] args) throws IOException {
        String[] a = {"hello", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"};
        String[] b = {"world", "wo", "aa", "bb", "cc", "dd", "ee", "ff", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi", "hi"};
        commonSubstring(Arrays.asList(a), Arrays.asList(b));
    }

    public static void commonSubstring(List<String> a, List<String> b) {
        String aStr = "";
        String bStr = "";
        for (int i = 0; i < a.size(); i++) {
            aStr = a.get(i);
            bStr = b.get(i);

            int[] alphabet = new int[200];

            for (int j = 0; j < aStr.length(); j++) {
                alphabet[aStr.charAt(j) - '0'] = 1;
            }

            boolean check = false;
            for (int k = 0; k < bStr.length(); k++) {
                if (alphabet[bStr.charAt(k) - '0'] != 0) {
                    check = true;
                    System.out.println("YES");
                    break;
                }
            }

            if (!check) {
                System.out.println("NO");
            }
        }
    }
}
