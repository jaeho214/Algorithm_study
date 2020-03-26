package kakao.blind2018;
/*
 * 변환을 못해서 오래걸렸다,, 멍청하다,,
 */
public class KAKAO_n진수게임 {
    public static void main(String[] args) {
        KAKAO_n진수게임 kakao_n진수게임 = new KAKAO_n진수게임();
        System.out.println(kakao_n진수게임.solution(	16, 16, 2, 1));
    }

    public String solution(int n, int t, int m, int p) {
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        while(true){
            sb.append(convert(idx++, n));
            if(sb.length() > t*m)
                break;
        }

        char[] arr = sb.toString().toCharArray();
        for(int i=p;i<arr.length;i+=m){
            res.append(arr[i-1]);
            if(res.length() == t)
                break;
        }
        return res.toString();
    }

    public String convert(int num, int n){
        if(num==0)
            return "0";
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            int tmp = num%n;
            //나눈 수가 10~15 라면 A~F로 대체
            //tmp - 10 에 따라 A~F가 다름
            // tmp == 11 일때 tmp-10은 1이고 'A'+1 은 'B'가 됨
            sb.append(tmp >= 10 ? String.valueOf((char)('A' + (tmp-10))) : tmp);
            num/=n;
        }
        return sb.reverse().toString();
    }
}
