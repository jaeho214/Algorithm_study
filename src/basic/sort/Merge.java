package basic.sort;

import java.util.Arrays;

/*
 * 합병 정렬 : 문제를 작은 2문제로 분리한 다음 결과를 모아서 해결하는 방식
 * 어떤한 경우에도 O(nlogn)의 시간복잡도를 가진다.
 * 배열로 진행할 경우 별도의 임시배열이 필요하다.
 * 연결리스트로 진행할 경우 인덱스만 바꾸면 되므로 간편
 */
public class Merge {
    int[] sorted;
    public static void main(String[] args) {
        Merge merge = new Merge();
        int[] input = {8,7,6,5,4,3,2,1};
        merge.init(input.length);
        merge.mergeSort(input, 0, input.length-1);
    }

    private void init(int length) {
        sorted = new int[length];
    }

    private void mergeSort(int[] input, int low, int high) {
        int mid = 0;
        if(low < high){
            mid = (low + high) / 2;
            mergeSort(input, low, mid);
            mergeSort(input, mid+1, high);
            merge(input, low, mid, high);
        }
    }

    private void merge(int[] input, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = low;

        while(i<=mid && j<=high){
            if(input[i] <= input[j]){
                sorted[k] = input[i];
                i++;
            }else{
                sorted[k] = input[j];
                j++;
            }
            k++;
        }
        if(i > mid){
            for(int idx=j;idx<=high;idx++, k++){
                sorted[k] = input[idx];
            }
        }else{
            for(int idx=i;idx<=mid;idx++, k++){
                sorted[k] = input[idx];
            }
        }

        for(int idx=low; idx<=high; idx++){
            input[idx] = sorted[idx];
        }
        System.out.println("병합 정렬 후 : " + Arrays.toString(input));
    }
}
