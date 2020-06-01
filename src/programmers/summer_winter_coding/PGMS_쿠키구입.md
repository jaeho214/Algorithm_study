# 📖 문제
https://programmers.co.kr/learn/courses/30/lessons/49995

# 🔍 접근법
first라는 변수를 첫째 아들, second라는 변수를 둘째 아들로 두었다.   
first와 second를 i와 i+1로 초기화를 시켜두고    
f_sum과 s_sum에 값을 쌓아준다.
   
f_sum과 s_sum의 값을 비교하여    
같을 경우에는 answer에 값을 저장하고 first, second 둘다 이동시킨다.    
s_sum이 큰 경우에는 first를 이동시키고   
f_sum이 큰 경우에는 second를 이동시킨다.

# 💻 코드
```
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

```