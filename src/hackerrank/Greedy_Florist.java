package hackerrank;

import java.util.Arrays;

public class Greedy_Florist {

    public static void main(String[] args) {
        int[] c = {1,3,5,7,9};
        System.out.println(getMinimumCost(3, c));
    }

    static int getMinimumCost(int k, int[] c) {
        int answer = 0;

        Arrays.sort(c);

        int idx = 0;
        for(int i=c.length-1, cnt=0; i>=0; i--, cnt++){
            if(cnt!= 0 && cnt%k==0) {
                idx ++;
            }
            answer += (idx + 1) * c[i];
        }
        return answer;
    }


}
