package codility.lesson5;

public class CountDiv {
    public static void main(String[] args) {
        CountDiv countDiv = new CountDiv();
        System.out.println(countDiv.solution(10, 10,20));
    }

    public int solution(int A, int B, int K) {
        int a = (A-1)/K;
        int b = B/K;

        if(A==0)
            return b+1;
        else
            return b-a;
    }
}
