package hackerrank.interview_preparation_kit;

public class HackerRank_Counting_Valleys {
    public static void main(String[] args) {
        countingValleys(9, "UDDDUDUU");
    }

    public static int countingValleys(int steps, String path) {
        int answer = 0;

        String[] paths = path.split("");
        int height = 0;

        for(int i=0;i<paths.length;i++){
            boolean isNegative = height == 0;
                if(paths[i].equals("U")) height++;
                else height--;

                if(isNegative &&  height < 0)
                    answer++;
        }

        return answer;
    }
}
