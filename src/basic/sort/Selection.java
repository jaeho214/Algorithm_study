package basic.sort;

/*
 * 선택정렬 : 최대값 또는 최소값을 찾아서 맨 뒤 또는 맨 앞에 저장시키며 정렬하는 방식
 * 시간 복잡도는 best, worst, average 모두 O(n^2)
 */
public class Selection {
    public static void main(String[] args) {
        Selection selection = new Selection();
        int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        int[] min = selection.selectionByMin(input);
        System.out.print("SelectionByMin : ");
        for(int m : min)
            System.out.print(m + " ");
        System.out.println();
        int[] max = selection.selectionByMax(input);
        System.out.print("SelectionByMax : ");
        for(int m : max)
            System.out.print(m + " ");
    }

    //정렬이 된 상태여도 포문은 모두 돌아간다.
    private int[] selectionByMax(int[] input) {
        for(int i=input.length-1; i>=0;i--){
            int max = i;
            for(int j=0; j<i;j++){
                if(input[max] < input[j])
                    max = j;
            }
            int temp = input[max];
            input[max] = input[i];
            input[i] = temp;
        }

        return input;
    }

    private int[] selectionByMin(int[] input){
        for(int i=0;i< input.length; i++){
            int min = i;
            for(int j=i+1;j< input.length;j++){
                if(input[min] > input[j])
                    min = j;
            }
            int temp = input[min];
            input[min] = input[i];
            input[i] = temp;
        }

        return input;
    }

}
