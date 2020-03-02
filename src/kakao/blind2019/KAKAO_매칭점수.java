package kakao.blind2019;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
 * https://dundung.tistory.com/126
 * 문장을 처음부터 끝까지 살피면서 하는 로직이었다.
 * 정규식으로 할 생각만하고 이렇게 풀 생각은 못했었다.
 */
public class KAKAO_매칭점수 {
    public static void main(String[] args) {
        KAKAO_매칭점수 kakao_매칭점수 = new KAKAO_매칭점수();
        String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta property=\"og:url\" content=\"https://a.com\"/>\n" +
                "</head>  \n" +
                "<body>\n" +
                "Blind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n" +
                "<a href=\"https://b.com\"> Link to b </a>\n" +
                "</body>\n" +
                "</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta property=\"og:url\" content=\"https://b.com\"/>\n" +
                "</head>  \n" +
                "<body>\n" +
                "Suspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n" +
                "<a href=\"https://a.com\"> Link to a </a>\n" +
                "blind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n" +
                "<a href=\"https://c.com\"> Link to c </a>\n" +
                "</body>\n" +
                "</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n" +
                "<head>\n" +
                "  <meta charset=\"utf-8\">\n" +
                "  <meta property=\"og:url\" content=\"https://c.com\"/>\n" +
                "</head>  \n" +
                "<body>\n" +
                "Ut condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n" +
                "<a href=\"https://a.com\"> Link to a </a>\n" +
                "</body>\n" +
                "</html>"};
        System.out.println(kakao_매칭점수.solution("blind", pages));
    }
    public class Page implements Comparable<Page>{
        int idx;
        int base;
        int link;
        double score;

        public Page(int idx, int base, int link, double score) {
            this.idx = idx;
            this.base = base;
            this.link = link;
            this.score = score;
        }

        @Override
        public int compareTo(Page o) {
            if(this.score == o.score){
                return this.idx-o.idx;
            }else if(this.score < o.score){
                return 1;
            }else{
                return -1;
            }
        }
    }
    public int solution(String word, String[] pages) {
        int word_len = word.length();
        word = word.toLowerCase();
        Map<String, Integer> pageMap = new HashMap<>();
        List<Page> pageList = new ArrayList<>();

        for(int i=0;i<pages.length;i++){
            StringBuilder sb = new StringBuilder(pages[i].toLowerCase());
            int mid=0, left=0, right=0;
            while(mid <= left){
                left = sb.indexOf("<meta", left+1);
                right = sb.indexOf(">", left);
                mid = sb.lastIndexOf("https://", right);
            }
            right = sb.indexOf("\"", mid);
            //웹페이지를 인덱스값을 통해서 찾는다
            String url = sb.substring(mid, right);

            //<body>쪽의 인덱스를 구해서
            left = sb.indexOf("<body>", right);
            int base = 0;
            //문장을 읽어나가면서
            for(int start=left;;){
                //word가 있는지를 찾는다
                start = sb.indexOf(word, start+1);
                //없으면 끝내고
                if(start < 0) break;

                //word 양옆의 값이 문자인지 확인하고
                if(!Character.isLetter(sb.charAt(start-1)) && !Character.isLetter(sb.charAt(start+word_len))){
                    //맞으면 기본점수 ++
                    base++;
                    //word 만큼 읽었으므로 word 만큼 더해준다
                    start += word_len;
                }
            }
            int link = 0;
            for(int start=left;;){
                //어떤 링크가 걸려있는지를 찾는다
                start = sb.indexOf("<a href", start+1);
                //링크가 없으면 끝내고
                if(start<0) break;
                //있으면 카운트
                link++;
            }
            //키를 url로 하고 value를 현재 i 값으로 한다.
            pageMap.put(url, i);
            //페이지 리스트에 추가
            pageList.add(new Page(i, base, link, (double) base));
        }

        //다시 페이지 리스트를 살피면서
        for(int i=0;i<pages.length;i++){
            StringBuilder sb = new StringBuilder(pages[i].toLowerCase());
            for(int left=0, right=0;;){
                //이 페이지가 어떠한 웹페이지를 참조하고 있는지 찾는다.
                left = sb.indexOf("<a href", right);
                //없으면 끝
                if(left<0) break;
                //하이퍼 링크가 있으면
                //그 url을 추출해낸다.
                left = sb.indexOf("https://", left);
                right = sb.indexOf("\"", left);
                String linkUrl = sb.substring(left, right);

                //참조된 url의 인덱스를 꺼내서
                Integer value = pageMap.get(linkUrl);
                if(value != null){
                    //참조된 url 페이지의 매칭점수에 현재 페이지의 기본점수에서 링크점수를 더해준다.
                    pageList.get(value).score += (double)pageList.get(i).base/pageList.get(i).link;
                }
            }
        }
        //큰순서 대로 정렬하고
        pageList.sort(Page::compareTo);
        //가장 큰 값의 인덱스를 return
        return pageList.get(0).idx;
    }
}
