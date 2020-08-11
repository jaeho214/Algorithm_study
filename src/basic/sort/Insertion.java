package basic.sort;

/*
 * 선택정렬 : 두 번째 원소부터 key로 놓고 key 앞에 있는 값들과 비교하며 정렬하는 방식
 * 배열이 정렬된 경우에는 O(n)의 시간복잡도를 가지고
 * 그 외의 경우에는 O(n^2)의 시간복잡도를 가진다.
 */
public class Insertion {
    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        //int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        int[] input = {1,2,3,4,5,6,7};
        int[] result = insertion.insertionSort(input);
        System.out.print("InsertionSort : ");
        for(int r : result){
            System.out.print(r + " ");
        }
    }

    private int[] insertionSort(int[] input) {

        for(int i=1;i< input.length;i++){
            for(int j=i;j>0;j--){
                if(input[j] < input[j-1]){
                    int temp = input[j-1];
                    input[j-1] = input[j];
                    input[j] = temp;
                }
            }
        }
        return input;
    }

}
