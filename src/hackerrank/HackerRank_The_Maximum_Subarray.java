package hackerrank;

import java.util.Arrays;

public class HackerRank_The_Maximum_Subarray {
    public static void main(String[] args) {
        int[] arr = {-1, -2, -3, -4, -5, -6};
        System.out.println(maxSubarray(arr));
    }

    static int[] maxSubarray(int[] arr) {

        int dp[] = new int[arr.length];
        dp[0] = arr[0];
        int max = dp[0];

        for(int i=1;i<arr.length;i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            max = Math.max(dp[i], max);
        }

        Arrays.sort(arr);
        int sum = arr[arr.length-1];
        for(int i=arr.length-2;i>=0;i--){
            if(sum + arr[i] < sum)
                break;
            sum += arr[i];
        }


        return new int[]{max, sum};
    }
}
