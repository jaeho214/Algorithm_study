package leetCode;

public class LEET_238_Product_of_Array_Except_Self {
    public static void main(String[] args) {
        LEET_238_Product_of_Array_Except_Self product_of_array_except_self = new LEET_238_Product_of_Array_Except_Self();
        int[] arr = {1,2,3,4};
        System.out.println(product_of_array_except_self.productExceptSelf(arr));
    }

    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        //첫 번째는 그냥 1
        answer[0] = 1;
        //두번째부터 쌓아가면서 곱셈
        for (int i = 1; i < nums.length; i++) {
            answer[i] = nums[i - 1] * answer[i - 1];
        }

        //거꾸로 오면서 곱셈
        int idx = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= idx;
            idx *= nums[i];
        }

        return answer;
    }
}
