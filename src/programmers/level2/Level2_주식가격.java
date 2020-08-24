package programmers.level2;

public class Level2_주식가격 {
    public static void main(String[] args) {
        Level2_주식가격 level2_주식가격 = new Level2_주식가격();
        int[] price = {1, 2, 3, 2, 3};
        System.out.println(level2_주식가격.solution(price));
    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i=0;i< prices.length;i++){
            int j;
            for(j=i+1;j< prices.length;j++){
                if(prices[i] > prices[j]){
                    answer[i] = j-i;
                    break;
                }else{
                    answer[i] = j-i;
                }
            }

        }

        return answer;
    }
}
