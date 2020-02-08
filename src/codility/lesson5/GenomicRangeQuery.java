package codility.lesson5;
/*
 * https://funnelgarden.com/genomicrangequery-codility-solution/
 */
public class GenomicRangeQuery {
    public static void main(String[] args) {
        GenomicRangeQuery genomicRangeQuery = new GenomicRangeQuery();
        int []p = {2,5,0};
        int []q = {4,5,6};
        int []res = genomicRangeQuery.solution("CAGCCTA", p, q);
        for (int i : res)
            System.out.print(i);
    }

    public int[] solution(String S, int[] P, int[] Q) {
        int res[] = new int[P.length];
        int len = S.length();
        //행 : 글자의 순서
        //열 : 알파벳별 현재 행(현재 글자)까지 나온 개수
        int[][] arr = new int[len][4];

        //일단 각 글자마다 알파벳이 나오면 1을 켜주고
        //  {0,1,0,0}  C
        //  {1,0,0,0}  A
        //  {0,0,1,0}  G
        //  {0,1,0,0}  C
        //  {0,1,0,0}  C
        //  {0,0,0,1}  T
        //  {1,0,0,0}  A
        for(int i=0;i<arr.length;i++){
            char c = S.charAt(i);
            if(c == 'A') arr[i][0] = 1;
            else if(c=='C') arr[i][1] = 1;
            else if(c=='G') arr[i][2] = 1;
            else if(c=='T') arr[i][3] = 1;
        }

        //모든 글자에 나온 알파벳 수를 축적한다.
        //최종적으로는 마지막 행에선 모든 A,C,G,T 의 개수가 각각 저장됨.
        //  {0,1,0,0}  C
        //  {1,1,0,0}  A
        //  {1,1,1,0}  G
        //  {1,2,1,0}  C
        //  {1,3,1,0}  C
        //  {1,3,1,1}  T
        //  {2,3,1,1}  A
        for(int i=1;i<len;i++){
            for(int j=0;j<4;j++){
                arr[i][j] += arr[i-1][j];
            }
        }

        for(int i=0;i<P.length;i++){
            //P와 Q를 받아서
            int p = P[i];
            int q = Q[i];

            //j는 A,C,G,T를 도는 것이므로 작은 글자의 변화가 감지되면 바로 break를 건다.
            for(int j=0;j<4;j++){
                int cnt = 0;
                //P의 바로 전 글자의
                //바로 전 글자도 가져오는 이유는 P번째의 글자까지 확인하기 위해서이다.
                if(p-1 >=0) {
                    //j 값을 가져온다.
                    cnt = arr[p - 1][j];
                }
                //Q의 j값과 P의 j값이 차이가 있을 때, 즉, 변화가 있을 때 그 글자는 존재하는 것으로 간주한다.
                if(arr[q][j] - cnt > 0){
                    res[i] = j+1;
                    break;
                }
            }
        }
        return res;
    }
}
