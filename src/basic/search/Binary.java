package basic.search;

public class Binary {
    public static void main(String[] args) {
        Binary binary = new Binary();
        int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        int idx = binary.binarySearch(input, 8);
        if(idx==-1)
            System.out.println("찾고자 하는 원소가 없습니다.");
        else
            System.out.println(idx+1 + "번째 인덱스에 찾고자 하는 원소가 있습니다.");

    }

    private int binarySearch(int[] input, int number) {

        quickSort(input, 0, input.length-1);
        int low = 0;
        int high = input.length;

        while(low<=high){
            int mid = (low+high)/2;
            if(input[mid] == number){
                return mid;
            }
            if(input[mid] < number){
                low = mid+1;
            }else{
                high = mid;
            }
        }

        return -1;
    }

    private void quickSort(int[] input, int left, int right) {
        int p = partition(input, left, right);

        if(left < p-1){
            quickSort(input, left, p-1);
        }
        if(p < right){
            quickSort(input, p, right);
        }
    }

    private int partition(int[] input, int left, int right) {

        int pivot = input[(left+right)/2];
        while(left <= right){
            while (input[left] < pivot) left++;
            while (input[right] > pivot) right--;

            if(left <= right){
                swap(input, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private void swap(int[] input, int left, int right) {
        int temp = input[left];
        input[left] = input[right];
        input[right] = temp;
    }
}
