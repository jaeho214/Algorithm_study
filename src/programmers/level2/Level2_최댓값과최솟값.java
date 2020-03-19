package programmers.level2;

public class Level2_최댓값과최솟값 {
    public static void main(String[] args) {
        Level2_최댓값과최솟값 level2_최댓값과최솟값 = new Level2_최댓값과최솟값();
        System.out.println(level2_최댓값과최솟값.solution("-1 -1"));
    }

    public String solution(String s) {
        String[] chars = s.split(" ");
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        for(String str : chars){
            max = Math.max(max, Integer.parseInt(str));
            min = Math.min(min, Integer.parseInt(str));
        }
        return min + " " + max;
    }
}
