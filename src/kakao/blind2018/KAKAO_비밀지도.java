package kakao.blind2018;

public class KAKAO_비밀지도 {
    public static void main(String[] args) {
        KAKAO_비밀지도 kakao_비밀지도 = new KAKAO_비밀지도();
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};
        System.out.println(kakao_비밀지도.solution(6,arr1,arr2));
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[] res = new int[n];
        for(int i=0;i<arr1.length;i++){
            res[i] = arr1[i] | arr2[i];
        }
        for(int i=0;i<res.length;i++){
            String bit = Integer.toBinaryString(res[i]);
            while(bit.length() < n){
                bit = "0" + bit;
            }
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<bit.length();j++){
                if(bit.charAt(j)=='1')
                    sb.append("#");
                else
                    sb.append(" ");
            }
            answer[i] = sb.toString();
        }

        return answer;
    }
}
