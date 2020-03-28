package programmers.level3;

public class Level3_종이접기 {
    public static void main(String[] args) {
        Level3_종이접기 level3_종이접기 = new Level3_종이접기();
        System.out.println(level3_종이접기.solution(2));
    }

    public int[] solution(int n) {
        int[] answer = {};
        int len = 1;
        for(int i=0;i<n-1;i++){
            len *=2;
            len++;
        }

        String res = recursion(1, len, true);
        answer = new int[res.length()];
        for(int i=0;i<res.length();i++){
            answer[i] = res.charAt(i)-'0';
        }
        return answer;
    }

    public String recursion(int left, int right, boolean flag){
        if(right==left){
            if(flag)
                return "0";
            else
                return "1";
        }

        int mid = (right+1 + left)/2;

        if(flag)
            return recursion(left, mid-1, true) + "0" + recursion(mid+1, right, false);
        else
            return recursion(left, mid-1, true) + "1" + recursion(mid+1, right, false);

    }

}
