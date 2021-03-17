package leetCode;

public class Leetcode_457_Circular_Array_Loop {
    public static void main(String[] args) {
        Leetcode_457_Circular_Array_Loop circular_array_loop = new Leetcode_457_Circular_Array_Loop();
        int[] nums = {-1,2};
        System.out.println(circular_array_loop.circularArrayLoop(nums));
    }

    public boolean circularArrayLoop(int[] nums) {
        //nums[i]의 한도는 1000
        final int limit = 1000;
        int visitedForward = limit;
        int visitedBackward = -limit;

        for(int i=0;i<nums.length;i++){
            //i부터 한바퀴 돌면서
            if(isVisited(nums[i], limit))
                continue;

            //해당 숫자가 양수라서 오른쪽으로 가는지, 아닌지에 대한 boolean 값
            boolean isForward = nums[i] > 0;

            //현재 인덱스를 저장해두고
            int next = i;
            //오른쪽 방향으로 가야하면 limit 양수값, 왼쪽으로 가야하면 limit 음수값
            int flag = isForward ? ++visitedForward : --visitedBackward;

            do{
                //한 바퀴 돈다.
                next = getNext(nums, next, isForward, flag);
            //원래 인덱스로 돌아올때까지
            }while(next > -1 && next != i && !isVisited(nums[next], limit));

            //원래 인덱스로 돌아오고 현재 인덱스가 이미 방문했다면 사이클 완성
            if(next > -1 && (next == i || nums[next] == flag)) return true;
        }
        return false;
    }

    private int getNext(int[] nums, int idx, boolean isForward, int flag) {
        //왼쪽/오른쪽 방향을 정하고
        boolean direction = nums[idx] > 0;

        //한 뱡향으로 가다가 방향이 달라지면 -1리턴
        if(direction != isForward)
            return -1;

        //다음 인덱스를 구하고
        int next = (idx+nums[idx]) % nums.length;

        //그 인덱스가 0보다 작다면 한바퀴 돌았다고 치고 인덱스 배정
        if(next < 0)
            next += nums.length;

        //방문했다고 기록해줌
        nums[idx] = flag;

        return next == idx ? -1 : next;
    }

    private boolean isVisited(int num, int limit) {
        return Math.abs(num) > limit;
    }



}
