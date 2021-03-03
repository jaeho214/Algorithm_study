package leetCode;

public class LEET_55_Jump_Game {
    public static void main(String[] args) {
        LEET_55_Jump_Game jumpGame = new LEET_55_Jump_Game();
        //int[] nums = {2,3,1,1,4};
        //System.out.println(jumpGame.canJump(nums));

        int[] nums2 = {3,2,3,0,4};
        System.out.println(jumpGame.canJump(nums2));
    }

    public boolean canJump(int[] nums) {
        //길이가 1이면 무조건 가능
        if(nums.length <= 1)
            return true;

        //우선 현재 갈 수 있는 위치에서 가장 먼 곳의 인덱스
        int max = nums[0];

        //반복문을 돌면서
        for(int i=0;i<nums.length;i++){
            //가장 멀리 갈 수 있는 곳에서도 넘지못하는 곳이 && 0이라면 불가능
            if(max <= i && nums[i] == 0)
                return false;

            //가장 멀리갈 수 있는 곳을 갱신
            max = Math.max(i+nums[i], max);

            //넘어서면 충분히 가능
            if(max >= nums.length-1)
                return true;
        }

        return false;
    }
}
