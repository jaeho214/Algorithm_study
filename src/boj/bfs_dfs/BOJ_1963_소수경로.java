package boj.bfs_dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 오래 걸렸지만 오랜만에 혼자 해결!
 */
public class BOJ_1963_소수경로 {
    static int t,a,b, res[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        for(int i=1;i<=t;i++){
            visited = new boolean[10001];
            res = new int[10001];
            StringTokenizer st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            bfs();
            System.out.println(res[b]);
        }
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int copy[] = new int[5];
        q.add(a);
        while(!q.isEmpty()) {
            a = q.poll();
            //큐에 있던 숫자를 배열로 바꿔줌
            int arr[] = int2Array(a);
            //배열을 카피해두고
            for(int i=1;i<arr.length;i++){
                copy[i] = arr[i];
            }
            visited[a] = true;
            for (int i = 1; i <= 4; i++) {
                for (int j = 0; j <= 9; j++) {
                    //arr의 값을 계속 바뀌므로 카피해둔 값과 비교
                    if(copy[i] != j) {
                        //arr값을 바꿔주면서
                        arr[i] = j;
                        int nextNum = array2Int(arr);
                        //네자리여야한다는 조건과 소수라는 조건에 만족하면 큐에 저장
                        if(nextNum >= 1000 && nextNum <= 9999) {
                            if (isPrime(nextNum) && !visited[nextNum]) {
                                q.add(nextNum);
                                visited[nextNum] = true;
                                res[nextNum] = res[a] + 1;
                            }
                        }
                        if(nextNum == b)
                            return;
                    }
                }
                //값이 계속 바뀌므로 다시 원래 arr값으로 돌려줌
                arr[i] = copy[i];
            }
        }
    }

    private static int[] int2Array(int a) {
        int arr[] = new int[5];
        String temp = String.valueOf(a);
        for(int i=1;i<=temp.length();i++){
            arr[i] = temp.charAt(i-1) - '0';
        }
        return arr;
    }

    private static int array2Int(int arr[]){
        StringBuilder sb = new StringBuilder();
        for(int i : arr){
            sb.append(i);
        }
        return Integer.parseInt(sb.toString());
    }

    //소수 판별 메소드
    private static boolean isPrime(int num){
        for(int i=2;i<num;i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

}
