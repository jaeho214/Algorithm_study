package basic.sort;

/*
 * 버블정렬 : 연속된 두 원소를 비교해가면서 swap하는 방식
 * best, worst, average 모두 O(n^2)
 * 이미 정렬이 된 상태여도 비교 연산을 위해 n^2만큼 돌아간다.
 */
public class Bubble {
    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        //int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        int[] input = {1,2,3,4,5,6,7};
        int[] result = bubble.bubbleSort(input);
        System.out.print("bubbleSort : ");
        for(int r : result)
            System.out.print(r + " ");
    }

    private int[] bubbleSort(int[] input) {

        for(int i=0;i< input.length;i++){
            for(int j=0;j< input.length-i-1; j++){
                if(input[j] > input[j+1]){
                    int temp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = temp;
                }
            }

        }
        return input;
    }
}
