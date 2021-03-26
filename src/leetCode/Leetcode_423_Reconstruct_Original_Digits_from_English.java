package leetCode;

public class Leetcode_423_Reconstruct_Original_Digits_from_English {
    public static void main(String[] args) {
        Leetcode_423_Reconstruct_Original_Digits_from_English r = new Leetcode_423_Reconstruct_Original_Digits_from_English();
        System.out.println(r.originalDigits("owoztneoer"));
    }
    public String originalDigits(String s) {
        int[] cnt = new int[10];
        int[] ch = new int[26];
        for(int i=0;i<s.length();i++){
            ch[s.charAt(i) - 'a'] ++;
        }

        StringBuilder answer = new StringBuilder();
        int [] order = {0,8,6,4,3,7,5,2,9,1};
        //유일하게 식별되는 값을 통해 찾기
        char[] unique = {'z', 'g', 'x', 'u', 'h', 's', 'f', 't', 'i', 'o'};
        String[] spelling = {"zero", "eight", "six","four","three","seven","five","two","nine","one"};

        for(int i=0;i<10;i++){
            //해당 알파벳의 인덱스를 구하고
            int idx = unique[i] - 'a';

            //그 알파벳의 개수를 s에 포함된 그 알파벳의 개수로 초기화
            cnt[order[i]] = ch[idx];

            //그 알파벳에 해당되는 단어를 돌면서
            for(int j=0;j<spelling[i].length();j++){
                int current = spelling[i].charAt(j) - 'a';
                //ch에서 점점 제거
                ch[current] -= cnt[order[i]];
            }
        }

        for(int i=0;i<10;i++){
            for(int j=0;j<cnt[i];j++){
                answer.append(i);
            }
        }

        return answer.toString();
    }


}
