package naver.burning;

public class NAVER_4 {
    public static void main(String[] args) {
        NAVER_4 naver_4 = new NAVER_4();
        int[] a= {0,1,0};
        System.out.println(naver_4.solution(a));
    }

    public int solution(int[] A) {{

        boolean[] a = new boolean[A.length];

        for(int i=0;i<A.length;i++){
            if(A[i] == 1)
                a[i] = true;
            else
                a[i] = false;
        }

        boolean[] first1 = new boolean[A.length];
        boolean[] first0 = new boolean[A.length];

        first0[0] = true;
        first0[1] = true;

        for(int i=1;i<A.length;i++){
            first0[i] = !first0[i-1];
            first1[i] = !first1[i-1];
        }

        int isEqual1 = 0, isEqual0 = 0;

        for(int i=0;i<A.length;i++){
            if(a[i] != first0[i])
                isEqual0 ++;
            if(a[i] != first1[i])
                isEqual1 ++;
        }

        return Math.min(isEqual0, isEqual1);
    }

    }
}
