package programmers;

public class PGMS_신규아이디추천_STRING {
    public static void main(String[] args) {
        PGMS_신규아이디추천_STRING pgms_신규아이디추천STRING = new PGMS_신규아이디추천_STRING();
        System.out.println(pgms_신규아이디추천STRING.solution("abcdefghijklmn.p"));
    }

    public static class NEW{
        private String str;

        public NEW(String str) {
            this.str = str;
        }

        public String getStr() {
            return str;
        }

        public NEW toLower(){
            this.str = this.str.toLowerCase();
            return this;
        }

        public NEW remove(){
            this.str = this.str.replaceAll("[^\\-_.a-z0-9]", "");
            return this;
        }

        public NEW removeDot(){
            this.str = this.str.replaceAll("[\\.]+", ".");
            return this;
        }

        public NEW trim(){
            this.str = str.replaceAll("^[.]|[.]$", "");
            return this;
        }

        public NEW substitute(){
            if(this.str.length() == 0)
                this.str = "a";
            return this;
        }

        public NEW removeIfOver16(){
            if(this.str.length() >= 16){
                this.str = this.str.substring(0, 15);
                if(this.str.charAt(this.str.length()-1) == '.')
                    this.str = this.str.substring(0, this.str.length()-1);
            }
            return this;
        }

        public NEW append(){
            if(this.str.length() <= 2){
                char last = str.charAt(str.length() - 1);
                while(this.str.length() < 3) this.str += last;
            }
            return this;
        }
    }

    public String solution(String new_id) {

        return new NEW(new_id)
                .toLower()
                .remove()
                .removeDot()
                .trim()
                .substitute()
                .removeIfOver16()
                .append()
                .getStr();
    }
}
