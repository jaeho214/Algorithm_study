package basic.search;

public class Linear {
    public static void main(String[] args) {
        Linear linear = new Linear();
        int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        int idx = linear.linearSearch(input, 8);
        if(idx==-1)
            System.out.println("찾고자 하는 원소가 없습니다.");
        else
            System.out.println(idx+1 + "번째 인덱스에 찾고자 하는 원소가 있습니다.");
    }

    private int linearSearch(int[] input, int number) {

        for(int i=0;i<input.length;i++){
            if(input[i] == number)
                return i;
        }
        return -1;
    }
}
