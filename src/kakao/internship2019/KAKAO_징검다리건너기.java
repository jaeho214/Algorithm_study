package kakao.internship2019;

public class KAKAO_징검다리건너기 {
    public static void main(String[] args) {
        KAKAO_징검다리건너기 kakao_징검다리건너기 = new KAKAO_징검다리건너기();
        int[] stones = {5,1,5,1,5,1,5,1,5};
        System.out.println(kakao_징검다리건너기.solution(stones, 2));
    }
    boolean visited[];
    int answer = Integer.MAX_VALUE;
    public int solution(int[] stones, int k) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i< stones.length;i++){
            min = Math.min(min, stones[i]);
            max = Math.max(max, stones[i]);
        }
        visited = new boolean[max+1];
        recursion(stones, k, min, max);

        return answer;
    }
    private void recursion(int[] stones, int k, int left, int right){
        int mid = (left+right)/2;
        if(visited[mid])
            return;

        visited[mid] = true;
        if(search(stones, k, mid)){
            recursion(stones, k, left, mid);
        }else{
            recursion(stones, k, mid, right);
        }
    }
    
    private boolean search(int[] stones, int k, int num){
        int cnt = 0;
        for(int stone : stones){
            if(stone > num){
                cnt = 0;
            }else{
                cnt++;
            }
            if(cnt==k) {
                answer = Math.min(num, answer);
                return true;
            }
        }
        return false;
    }
}
