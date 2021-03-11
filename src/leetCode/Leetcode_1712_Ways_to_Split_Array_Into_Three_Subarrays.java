package leetCode;

public class Leetcode_1712_Ways_to_Split_Array_Into_Three_Subarrays {
    public static void main(String[] args) {
        Leetcode_1712_Ways_to_Split_Array_Into_Three_Subarrays ways_to_split_array_into_three_subarrays = new Leetcode_1712_Ways_to_Split_Array_Into_Three_Subarrays();
        int[] nums = {1,2,2,2,5,0};
        System.out.println(ways_to_split_array_into_three_subarrays.waysToSplit(nums));
    }

    public int waysToSplit(int[] nums) {

        int answer = 0;
        int MOD = 1000000007;

        int[] sums = new int[nums.length+1];

        //누적 합을 구하고
        for(int i=1;i<=nums.length;i++){
            sums[i] = sums[i-1] + nums[i-1];
        }

        //j는 mid의 인덱스, k는 right의 인덱스
        int j=1, k=2;

        for(int i=0;i<nums.length-2;i++){
            //left의 합을 구하고
            int left = sums[i+1];
            //나머지 오른쪽 값의 중간값을 구한다.
            int target = (sums[nums.length] - sums[i+1])/2;

            //left 값이 중간값을 지나쳐버리면 브레이크
            if(target < left) break;

            //left의 합이 mid보다 커지면 종료
            while(j<=i || j < nums.length-1 && sums[j+1]-sums[i+1] < left){ j ++;}

            //mid의 합이 right의 합보다 커지면 종료
            while(k<j || k < nums.length-1 && sums[k+1] - sums[i+1] <= sums[nums.length] - sums[k+1]){ k++;}

            //j에서 k로 가는동안에 mid의 값이 right보다 작았음에도 k를 계속 카운트했다
            //그렇기 때문에 그 사이의 값들도 부분 배열로 가능하다는 이야기
            answer = (answer + k - j) % MOD;
        }

        return answer;
    }

}
