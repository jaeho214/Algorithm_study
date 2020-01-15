package search;

public class PGMS_카펫 {

    public static void main(String[] args) {
        PGMS_카펫 pgms_카펫 = new PGMS_카펫();
        System.out.println(pgms_카펫.solution(24,24));
    }

    public int[] solution(int brown, int red) {
        int area = brown + red;
        int[] answer = new int[2];
        for(int i=area/2;i>=1;i--){
            int height = area / i;
            int width = i;
            if(area % i != 0)
                continue;
            if(width <= 2 || height <= 2)
                continue;
            if(width < height)
                break;
            if((width-2) * (height-2) == red){
                answer[0] = width;
                answer[1] = height;
                break;
            }

        }
        return answer;
    }
}
