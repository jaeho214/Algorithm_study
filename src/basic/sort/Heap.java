package basic.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Heap {
    public static void main(String[] args) {
        Heap heap = new Heap();
        int n;
        int[] input = {};
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            n = Integer.parseInt(br.readLine());
            input = new int[n];
            for(int i=0;i<n;i++){
                input[i] = Integer.parseInt(br.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        heap.heapSort(input);
        System.out.println("HeapSort : " + Arrays.toString(input));
    }

    //heap을 만드는데 n
    private void heapInit(int[] input) {
        for(int i=1; i< input.length; i++){
            //현재 노드를 정하고
            int node = i;
            do{
                //현재 노드의 부모 노드를 구한다.
                int parent = (node-1)/2;
                //현재 노드와 부모 노드를 비교하였을 때 현재 노드가 더 크면
                if(input[parent] < input[node]){
                    //현재 노드와 부모 노드를 바꿔준다.
                    swap(input, parent, node);
                }
                //현재 노드가 부모노드가 된다.
                node = parent;
            //노드가 root로 올라가면 끝
            } while(node != 0);
        }
    }

    //logn ( 힙의 높이 만큼정도만 돌아감 )
    private void heapSort(int[] input) {

        heapInit(input);

        for(int i= input.length-1; i>=0; i--){
            //root 와 마지막 노드와 바꾼다.
            swap(input, 0, i);
            int parent = 0;
            int child;
            do {
                //왼쪽 자식 노드를 구하고
                child = 2 * parent + 1;
                //자식 노드 두개를 비교해서 더 높은 값을 찾아준다.
                //왼쪽 자식 노드이고, i는 이미 확정인 자리이므로 i-1
                if(child < i-1 && input[child] < input[child+1]){
                    child ++;
                }
                //부모보다 자식이 더 크다면
                //오른쪽 자식 노드이므로 i
                if(child < i && input[parent] < input[child]){
                    swap(input, parent, child);
                }
                parent = child;
            }while (child < i);
        }
    }

    private void swap(int[] input, int a, int b){
        int temp = input[a];
        input[a] = input[b];
        input[b] = temp;
    }
}
