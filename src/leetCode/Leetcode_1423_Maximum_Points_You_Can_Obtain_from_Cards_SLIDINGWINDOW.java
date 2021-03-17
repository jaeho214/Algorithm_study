package leetCode;

public class Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_SLIDINGWINDOW {
    public static void main(String[] args) {
        Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_SLIDINGWINDOW m = new Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_SLIDINGWINDOW();
        int[] cards = {1,2,3,4,5,6,1};
        System.out.println(m.maxScore(cards, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int min = Integer.MAX_VALUE;
        int window=0, total = 0;

        //전체합을 구하고
        for(int i=0;i<cardPoints.length;i++){
            total += cardPoints[i];
        }

        //슬라이딩 윈도우에 전체개수-k개를 넣는다.
        for(int i=0;i<cardPoints.length-k;i++){
            window += cardPoints[i];
        }

        //슬라이딩 윈도우의 합이 최소가 되어야 나머지 값의 합이 최대가 된다.
        min = Math.min(window, min);

        //왼쪽에서부터 다시 진행하면서
        for(int i=0, j=cardPoints.length-k;i<k;i++, j++){
            //왼쪽꺼를 빼고
            window -= cardPoints[i];
            //오른쪽꺼를 더하면서 오른쪽으로 슬라이딩 윈도우 이동
            window += cardPoints[j];
            //슬라이딩 윈도우 최소값 구하기
            min = Math.min(window, min);
        }

        //전체 합에서 슬라이딩 윈도우를 뺀 값이 반환
        return total - min;
    }

}
