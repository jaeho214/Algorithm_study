package leetCode;

public class Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_DP {
    public static void main(String[] args) {
        Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_DP m = new Leetcode_1423_Maximum_Points_You_Can_Obtain_from_Cards_DP();
        int[] cards = {1,2,3,4,5,6,1};
        System.out.println(m.maxScore(cards, 3));
    }

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;

        if(len == 0 || k == 0) return 0;

        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = cardPoints[0];
        right[len-1] = cardPoints[len-1];

        //왼쪽에서부터 순차적으로 합을 저장
        for(int i=1;i<len;i++){
            left[i] = left[i-1] + cardPoints[i];
        }

        //오른쪽에서부터 순차적으로 합을 저장
        for(int i=len-2;i>=0;i--){
            right[i] = right[i+1] + cardPoints[i];
        }

        int max = 0;

        // OXXXXXOOO 처럼 왼쪽 한개와 오른쪽 나머지의 최대값을 구한다.
        // OOXXXXXOO OOOXXXXXO OOOOXXXXX 처럼 X를 오른쪽으로 옮겨간다.
        for(int i=0;i<k-1;i++){
            max = Math.max(max, left[i] + right[len-k+i+1]);
        }

        max = Math.max(max, Math.max(left[k-1], right[len-k]));
        return max;
    }

}
