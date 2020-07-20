package hackerrank.ict;

import java.util.*;

public class Number1 {
    public static void main(String[] args) {
        int[] arr = {45,244};
        List<Integer> list = new ArrayList<>();
        for(int a : arr)
            list.add(a);
        System.out.println(countStudents(list));
    }

    public static int countStudents(List<Integer> height){
        int cnt = 0;
        List<Integer> copy = new ArrayList<>();
        for(int h : height)
            copy.add(h);

        Collections.sort(height);

        for(int i=0;i<height.size();i++){
            if(!height.get(i).equals(copy.get(i)))
                cnt++;
        }

        return cnt;
    }
}
