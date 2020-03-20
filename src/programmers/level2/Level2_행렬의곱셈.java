package programmers.level2;

public class Level2_행렬의곱셈 {
    public static void main(String[] args) {
        Level2_행렬의곱셈 level2_행렬의곱셈 = new Level2_행렬의곱셈();
        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};
        System.out.println(level2_행렬의곱셈.solution(arr1, arr2));
    }
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int leftRow = arr1.length, leftCol = arr1[0].length;
        int rightCol = arr2[0].length;
        int[][] answer = new int[leftRow][rightCol];

        for(int i=0;i<leftRow;i++){
            for(int j=0;j<leftCol;j++){
                for(int k=0;k<rightCol;k++){
                    answer[i][k] += arr1[i][j] * arr2[j][k];
                }
            }
        }
        return answer;
    }
}
