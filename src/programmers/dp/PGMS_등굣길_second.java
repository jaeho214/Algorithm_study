package programmers.dp;

public class PGMS_등굣길_second {
    public static void main(String[] args) {
        PGMS_등굣길_second pgms_등굣길_second = new PGMS_등굣길_second();
        int[][] puddles = {{2,1}, {2,2}, {2,3}};
        System.out.println(pgms_등굣길_second.solution(4, 3, puddles));
    }

    public int solution(int m, int n, int[][] puddles) {

        int[][] arr = new int[m+1][n+1];

        for(int i=0;i<puddles.length;i++){
            arr[puddles[i][0]][puddles[i][1]] = -1;
        }

        arr[1][1] = 1;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(i==1 && j==1)
                    continue;

                if(arr[i][j] == -1){
                    arr[i][j] = 0;
                    continue;
                }

                arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000007;

            }
        }

        return arr[m][n];
    }
}
