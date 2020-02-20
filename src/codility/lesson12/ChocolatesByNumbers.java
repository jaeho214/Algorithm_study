package codility.lesson12;

/*
 * 두 수의 최대공약수를 구하고 N에서 최대공약수를 나누면 되는 문제였다.
 * 반복문으로 모두 돌려고 하니 time error가 났고
 * 배열에 넣어놓고 체킹하니 heap 메모리 에러가 났다.
 * 규칙을 찾지 못해서 제대로 풀지 못했다
 * 결국 75% 퍼포먼스 점수
 */
public class ChocolatesByNumbers {

    public static void main(String[] args) {
        ChocolatesByNumbers chocolatesByNumbers = new ChocolatesByNumbers();
        System.out.println(chocolatesByNumbers.solution(10,4));
    }

    public int solution(int N, int M) {
        if(N==1)
            return 1;
        if(M==1)
            return N;

        int res = getNum(N,M);

        return N/res;
    }

    //재귀로 최대공약수 구하기
    private int getNum(int n, int m){
        if(m==0) return n;
        return getNum(m, n%m);
    }
}
