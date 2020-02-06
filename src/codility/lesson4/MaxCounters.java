package codility.lesson4;
/*
 * https://denken-y.tistory.com/entry/Codility-MaxCounters
 * 거의 다 풀었는데 마지막 하나 시간초과로 못풀었다..
 */
public class MaxCounters {

    public static void main(String[] args) {
        MaxCounters maxCounters = new MaxCounters();
        int[] arr = {3,4,4,6,1,4,4};
        System.out.println(maxCounters.solution(5,arr));
    }

    public int[] solution(int N, int[] A) {
        int arr[] = new int[N];
        int tmp = 0; // 배열 중 최대값
        int idx = 0;
        int max = 0; // N+1이 나올때마다 쌓인 tmp
        for(int a : A){
            if(a <= N){
                idx = a-1;

                //max값이 안되면 max값으로 바꿔주기
                if(arr[idx] < max)
                    arr[idx] = max;

                arr[idx]++;

                //배열의 값 중에 최대값 찾기
                if(arr[idx] > tmp + max)
                    tmp = arr[idx] - max;
            }
            else if(a==N+1){
                max += tmp;
                tmp=0;
            }
        }

         for(int i=0;i<N;i++){
             if(arr[i] < max)
                 arr[i] = max;
         }

        return arr;
    }

}
