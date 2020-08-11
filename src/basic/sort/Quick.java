package basic.sort;

import java.util.Arrays;
/*
 * 퀵 정렬 : 피벗을 임의로 지정하고 피벗 왼쪽에는 피벗보다 작은값, 피벗 오른쪽에는 피벗보다 큰값을 지정해주고 정렬하는 방법
 * 정렬 방법 중 가장 빠름
 * 정렬된 리스트를 정렬할 때 오히려 더 오래걸림
 * 피벗이 최대값 또는 최소값인 경우 O(n^2)만큼 걸림
 * 그 외의 경우는 O(nlogn)
 */
public class Quick {
    public static void main(String[] args) {
        Quick quick = new Quick();
        int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        System.out.println("before : " + Arrays.toString(input));
        int[] result = quick.quickSort(input, 0, input.length-1);
        System.out.print("result : ");
        System.out.println(Arrays.toString(result));
    }

    private int[] quickSort(int[] input, int left, int right) {
        int p = partition(input, left, right);

        if (left < p - 1)
            quickSort(input, left, p - 1);
        if (p < right)
            quickSort(input, p, right);
        return input;
    }

    private int partition(int[] input, int left, int right) {
        int mid = (left+right) / 2;
        int pivot = input[mid];

        while(left <= right){
            while(input[left] < pivot)
                left ++;
            while(input[right] > pivot)
                right --;

            if(left <= right){
                int tmp = input[left];
                input[left] = input[right];
                input[right] = tmp;
                left ++;
                right --;
            }
        }
        System.out.println("피벗 : " + pivot);
        System.out.println("퀵 정렬 진행 중 : " + Arrays.toString(input));
        return left;
    }
}
