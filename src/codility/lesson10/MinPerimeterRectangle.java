package codility.lesson10;

public class MinPerimeterRectangle {
    public static void main(String[] args) {
        MinPerimeterRectangle minPerimeterRectangle = new MinPerimeterRectangle();
        System.out.println(minPerimeterRectangle.solution(30));
    }

    public int solution(int N) {
        int min = Integer.MAX_VALUE;
        for(int i=1;i<=N;i++){
            if(i > N/i)
                break;
            if(N%i==0){
                int width = i;
                int height = N/i;
                min = Math.min(min, 2*(width+height));
            }
        }
        return min;
    }
}
