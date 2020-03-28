package kakao.blind2018;

import java.util.*;

public class KAKAO_파일명정렬 {
    public static void main(String[] args) {
        KAKAO_파일명정렬 kakao_파일명정렬 = new KAKAO_파일명정렬();
        String[] files = {"img1", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"};
        System.out.println(kakao_파일명정렬.solution(files));
    }

    public class File implements Comparable<File> {
        String fileName;
        String head;
        int number;
        public File(String fileName, String head, int number) {
            this.fileName = fileName;
            this.head = head;
            this.number = number;
        }

        @Override
        public int compareTo(File o) {
            if(this.head.toUpperCase().compareTo(o.head.toUpperCase())>0){
                return 1;
            }else if(this.head.toUpperCase().compareTo(o.head.toUpperCase())<0) {
                return -1;
            }else{
                if(this.number > o.number)
                    return 1;
                else if(this.number < o.number)
                    return -1;
                return 0;
            }
        }
    }

    public String[] solution(String[] files) {
        String[] answer = {};

        List<File> fileList = new ArrayList<>();

        for(String file : files){
            String ori = file;
            String head = file.split("[0-9]")[0];
            file = file.replace(head, "");
            head = head.toUpperCase();

            StringBuilder number = new StringBuilder();
            for(char c : file.toCharArray()){
                if(Character.isDigit(c) && number.length() < 5)
                    number.append(c);
                else
                    break;;
            }
            fileList.add(new File(ori, head, Integer.parseInt(number.toString())));
        }
        fileList.sort(File::compareTo);
        answer = new String[fileList.size()];
        for(int i=0;i<fileList.size();i++){
            answer[i] = fileList.get(i).fileName;
        }
        return answer;
    }
}
