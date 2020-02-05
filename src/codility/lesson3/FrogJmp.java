package codility.lesson3;

public class FrogJmp {

    public static void main(String[] args) {
        FrogJmp frogJmp = new FrogJmp();
        System.out.println(frogJmp.solution(10,85,30));
    }

    public int solution(int X, int Y, int D) {
        int num = Y-X;

        return (num/D)+1;
    }
}
