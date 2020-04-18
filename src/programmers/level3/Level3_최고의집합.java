package programmers.level3;

public class Level3_최고의집합 {
    public static void main(String[] args) {
        Level3_최고의집합 level3_최고의집합 = new Level3_최고의집합();
        System.out.println(level3_최고의집합.solution(4, 7));
    }

    public int[] solution(int n, int s) {
        int[] answer = {};

        if(n > s) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        int share = s/n;
        int remainder = (s%n);

        answer = new int[n];

        for(int i=0;i<n;i++){
            if(i < n-remainder)
                answer[i] = share;
            else
                answer[i] = share+1;
        }

        return answer;
    }
}
