package hash;


public class PGMS_전화번호목록 {
    public static void main(String[] args) {
        String[] phone_book = {"123","456", "789"};
        PGMS_전화번호목록 pgms_전화번호목록 = new PGMS_전화번호목록();
        System.out.println(pgms_전화번호목록.solution(phone_book));

    }


    public boolean solution(String[] phone_book) {
        //원래 정렬을 하고 풀었는데 정렬을 이용하면 효율성 테스트에서 실패함

        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book.length;j++){
                if(i==j)
                    continue;
                if(phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }

        return true;
    }
}
