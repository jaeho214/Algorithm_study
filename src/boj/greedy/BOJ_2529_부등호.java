package boj.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
/*
 * https://mygumi.tistory.com/279
 */
public class BOJ_2529_부등호 {

    static int n;
    static String[] sign;
    static boolean visited[] = new boolean[10];
    //모든 가능성들이 들어가는 리스트
    static List<String> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        input();

        for(int i=0;i<10;i++){
            visited[i] = true;
            solve(0, i, String.valueOf(i));
        }
        System.out.println(result.get(result.size()-1));
        System.out.println(result.get(0));

    }

    private static void solve(int idx, int before, String str) {
        //개수가 채워지면 list에 추가
        if(idx == n){
            result.add(str);
        }else {
            for (int i = 0; i < 10; i++) {
                if (!visited[i]) {
                    //부등호가 < 일때
                    if (sign[idx].equals("<")) {
                        // "<" 왼쪽에 있는 것보다 커야 함
                        if (before >= i) {
                            continue;
                        }
                    // 부등호가 >라면
                    } else {
                        // ">" 왼쪽에 있는 것보다 작아야 함
                        if (before <= i) {
                            continue;
                        }
                    }
                    visited[i] = true;
                    solve(idx + 1, i, str + i);
                }
            }
        }
        visited[before] = false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sign = br.readLine().split(" ");

    }
}
