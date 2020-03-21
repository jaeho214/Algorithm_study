package programmers.level2;

public class Level2_N개의최소공배수 {
    public static void main(String[] args) {
        Level2_N개의최소공배수 level2_n개의최소공배수 = new Level2_N개의최소공배수();
        int[] arr = {2,6,8,14};
        System.out.println(level2_n개의최소공배수.solution(arr));
    }

    public int solution(int[] arr) {
        int answer = 0;

        int max = arr[0];
        int idx = 1;
        for(int a : arr)
            max = Math.max(max, a);

        while(true) {
            boolean check = false;
            int num = max * idx++;
            for(int i=0;i<arr.length;i++){
                if(num % arr[i] != 0) {
                    check = true;
                    break;
                }
            }
            if(!check) {
                answer = num;
                break;
            }
        }

        return answer;
    }
}
