package codility.lesson5;

public class PassingCars {
    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();
        int[] a = {0,1,0,1,1};
        System.out.println(passingCars.solution(a));
    }

    public int solution(int[] A) {
        int cnt=0, tmp=0;
        int len = A.length;
        for(int i=0;i<len;i++){
            if(A[i] == 0){
                tmp ++;
                continue;
            }
            cnt += tmp;
            if(cnt > 1000000000)
                return -1;
        }
        return cnt;
    }
}
