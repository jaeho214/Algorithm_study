package kakao.blind2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KAKAO_파일명정렬_second {
    public static void main(String[] args) {
        KAKAO_파일명정렬_second kakao_파일명정렬_second = new KAKAO_파일명정렬_second();
        String[] files = {"f1", "Amg10.png", "Bmg02.png", "Cmg1.png", "IMG01.gif", "amg2.JPG"};
        System.out.println(kakao_파일명정렬_second.solution(files));
    }

    public String[] solution(String[] files) {
        String[] answer = {};

        List<FILE> fileList = new ArrayList<>();
        for(String file : files){
            int idx = 0;
            StringBuilder header = new StringBuilder();
            while(idx < file.length() && !Character.isDigit(file.charAt(idx))){
                header.append(file.charAt(idx));
                idx ++;
            }

            StringBuilder number = new StringBuilder();
            while(idx < file.length() && Character.isDigit(file.charAt(idx))){
                number.append(file.charAt(idx));
                idx++;
            }

            fileList.add(new FILE(header.toString(), number.toString(), file.substring(idx)));
        }

        Collections.sort(fileList);

        answer = new String[fileList.size()];

        for(int i=0;i<fileList.size();i++){
            answer[i] = fileList.get(i).toString();
        }

        return answer;
    }

    private static class FILE implements Comparable<FILE> {
        private String header;
        private String number;
        private String tail;

        public FILE(String header, String number, String tail) {
            this.header = header;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return header + number + tail;
        }

        @Override
        public int compareTo(FILE o) {
            if(this.header.toLowerCase().compareTo(o.header.toLowerCase()) > 0){
                return 1;
            }else if(this.header.toLowerCase().compareTo(o.header.toLowerCase()) < 0){
                return -1;
            }else{
                if(Integer.parseInt(this.number) > Integer.parseInt(o.number))
                    return 1;
                else if(Integer.parseInt(this.number) < Integer.parseInt(o.number))
                    return -1;
                else
                    return 0;
            }
        }
    }
}
