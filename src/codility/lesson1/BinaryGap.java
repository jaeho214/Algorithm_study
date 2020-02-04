package codility.lesson1;

public class BinaryGap {

    public static void main(String[] args) {
        BinaryGap binaryGap = new BinaryGap();
        System.out.println(binaryGap.solution(32));
    }

    public int solution(int N) {
        String str = Integer.toBinaryString(N);
        int cnt = 0, max = Integer.MIN_VALUE;
        if(!str.contains("1") || !str.contains("0"))
            return 0;

        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1'){
                max = Math.max(cnt, max);
                cnt = 0;
                continue;
            }
            cnt++;
        }
        return max;
    }
}
