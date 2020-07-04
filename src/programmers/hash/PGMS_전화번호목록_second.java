package programmers.hash;

public class PGMS_전화번호목록_second {
    public static void main(String[] args) {
        PGMS_전화번호목록_second pgms_전화번호목록_second = new PGMS_전화번호목록_second();
        String[] phone_book = {"12"};
        System.out.println(pgms_전화번호목록_second.solution(phone_book));
    }

    public boolean solution(String[] phone_book) {

        for(int i=0;i<phone_book.length;i++){
            for(int j=0;j<phone_book.length;j++){
                if(i==j)
                    continue;
                if(phone_book[j].startsWith(phone_book[i])){
                    return false;
                }
            }
        }

        return true;
    }
}
