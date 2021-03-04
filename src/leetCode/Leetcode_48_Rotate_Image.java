package leetCode;

public class Leetcode_48_Rotate_Image {
    public static void main(String[] args) {
        Leetcode_48_Rotate_Image rotateImage = new Leetcode_48_Rotate_Image();
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotateImage.rotate(mat);
    }

    public void rotate(int[][] matrix) {
        int len = matrix.length;
        // /자를 기준으로 뒤집고
        for(int i=0;i<len;i++){
            for(int j=0;j<len-i;j++){
                if(len-1-j == i && len-1-i==j)
                    continue;
                int tmp = matrix[len-1-j][len-1-i];
                matrix[len-1-j][len-1-i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // ㅡ자를 기준으로 뒤집는다
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len;j++){
                int tmp = matrix[len-1-i][j];
                matrix[len-1-i][j] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
