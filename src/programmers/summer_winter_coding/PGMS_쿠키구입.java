package programmers.summer_winter_coding;

public class PGMS_쿠키구입 {
    public static void main(String[] args) {
        PGMS_쿠키구입 pgms_쿠키구입 = new PGMS_쿠키구입();
        int[] cookies = {1,1,1};
        System.out.println(pgms_쿠키구입.solution(cookies));
    }

    public int solution(int[] cookie) {
        int answer = -1;

        for(int i=0;i<cookie.length-1;i++){
            int first = i, second = i+1;
            int f_sum = 0, s_sum = 0;
            int flag = 0;
            while(true){
                try {
                    if(flag == 0) {
                        f_sum += cookie[first];
                        s_sum += cookie[second];
                    }else if(flag == 1){
                        f_sum += cookie[first];
                    }else if(flag == 2){
                        s_sum += cookie[second];
                    }

                    if (f_sum == s_sum) {
                        answer = Math.max(f_sum, answer);
                        first --;
                        second ++;
                        flag = 0;
                    }
                    if (f_sum < s_sum) {
                        first--;
                        flag = 1;
                    }else if(f_sum > s_sum){
                        second++;
                        flag = 2;
                    }
                }catch (Exception e){
                    break;
                }
            }
        }

        if(answer == -1)
            return 0;
        return answer;
    }

}
