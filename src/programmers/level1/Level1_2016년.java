package programmers.level1;

public class Level1_2016년 {
    public static void main(String[] args) {
        Level1_2016년 level1_2016년 = new Level1_2016년();
        System.out.println(level1_2016년.solution(9, 30));
    }

    public String solution(int a, int b) {
        int[] month = {31,29,31,30,31,30,31,31,30,31,30,31};
        int sum = b;
        for(int i=0;i<a-1;i++){
            sum += month[i];
        }

        int result = (sum-1) % 7;
        switch (result){
            case 0:
                return "FRI";
            case 1:
                return "SAT";
            case 2:
                return "SUN";
            case 3:
                return "MON";
            case 4:
                return "TUE";
            case 5:
                return "WED";
            case 6:
                return "THU";
        }
        return null;
    }

}
