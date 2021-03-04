package leetCode;

public class Leetcode_11_Container_with_most_water {
    public static void main(String[] args) {
        Leetcode_11_Container_with_most_water container_with_most_water = new Leetcode_11_Container_with_most_water();
        int[] height = {1,2,1};
        System.out.println(container_with_most_water.maxArea(height));
    }

    public int maxArea(int[] height) {

        //가장 양쪽 끝점에서 시작해서
        int left = 0;
        int right= height.length - 1;

        //양 끝점의 최대값을 구하고
        int answer = (right-left) * Math.min(height[left], height[right]);

        while(left<right){
            //막대가 더 작은 값에 따라 값이 좌우하기 때문에 작은 막대를 계속 바꿔가면서
            if(height[left] <= height[right]) left++;
            else right--;

            //최대값 갱신
            answer = Math.max(answer, (right-left)*Math.min(height[left], height[right]));
        }

        return answer;
    }
}
