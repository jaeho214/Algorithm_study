package programmers.level2;
/*
 * 보자마자 삼중 포문을 생각했지만 당연히 시간초과가 날 것이라고 생각해서 시도해보지 않았다,,
 * 근데 삼중 포문으로 푸니까 맞았다,, 해볼걸
 */
public class Level2_소수만들기 {
    public static void main(String[] args) {
        Level2_소수만들기 level2_소수만들기 = new Level2_소수만들기();
        int[] nums = {1,4,5,7,8};
        System.out.println(level2_소수만들기.solution(nums));
    }
    public int solution(int[] nums) {
        int answer = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k=j+1;k<nums.length;k++){
                    int num = nums[i] + nums[j] + nums[k];
                    if(num >= 2 && isPrime(num))
                        answer++;
                }
            }
        }
        return answer;
    }

    public boolean isPrime(int num) {
        if (num == 2)
            return true;

        if (num % 2 == 0)
            return false;

        for (int j = 3; j <= Math.sqrt(num); j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;

    }
}
