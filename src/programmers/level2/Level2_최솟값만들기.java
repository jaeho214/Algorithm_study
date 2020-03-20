package programmers.level2;

public class Level2_최솟값만들기 {
    public static void main(String[] args) {
        Level2_최솟값만들기 level2_최솟값만들기 = new Level2_최솟값만들기();
        int[] a = {1,4,2};
        int[] b = {5,4,4};
        System.out.println(level2_최솟값만들기.solution(a, b));
    }

    public int solution(int []A, int []B) {
        int answer = 0;

        quickSort(A, 0, A.length-1);
        quickSort(B, 0, B.length-1);

        for(int i=0;i<A.length;i++){
            answer += A[i] * B[B.length-1-i];
        }

        return answer;
    }

    private void quickSort(int[] arr, int left, int right){
        int i,j, pivot, tmp;
        if(left < right){
            i = left;
            j = right;
            pivot = arr[i];

            while(i<j){
                while(arr[j] > pivot) j--;
                while(i<j && arr[i]<=pivot) i++;

                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            arr[left] = arr[i];
            arr[i] = pivot;

            quickSort(arr, left, i-1);
            quickSort(arr, i+1, right);
        }
    }
}
