package leetCode;

public class Leetcode_1139_Largest_1_Bordered_Square_DP {
    public static void main(String[] args) {
        Leetcode_1139_Largest_1_Bordered_Square_DP leetcode_1139_largest_1_bordered_squareDP = new Leetcode_1139_Largest_1_Bordered_Square_DP();
        int[][] grid = {{1,1,1}, {1,0,1}, {1,1,1}};
        System.out.println(leetcode_1139_largest_1_bordered_squareDP.largest1BorderedSquare(grid));
    }

    public int largest1BorderedSquare(int[][] grid) {
        int[][] leftToRight = new int[grid.length+1][grid[0].length+1];
        int[][] upToDown = new int[grid.length+1][grid[0].length+1];

        int answer = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                //만약 1이면 그 좌표 기준으로 오른쪽 값과 아래 값을 확인하면 1이면 이전보다 +1
                if(grid[i][j] == 1){
                    leftToRight[i+1][j+1] = leftToRight[i+1][j] + 1;
                    upToDown[i+1][j+1] = upToDown[i][j+1] + 1;
                }

                //더 짧은 길이로 정사각형을 만들 수 있으므로 더 짧은 길이부터 확인해나가며
                for(int max = Math.min(leftToRight[i+1][j+1], upToDown[i+1][j+1]); max >= 1; max--){
                    //현재 인덱스에서 max만큼 이전이 현재 max보다 길다면
                    if(leftToRight[i+1-max+1][j+1] >= max && upToDown[i+1][j+1-max+1]>= max){
                        //최대값 갱신
                        answer = Math.max(answer, max);
                        break;
                    }
                }
            }
        }
        return answer*answer;
    }
}
