package kakao.blind2018;

public class KAKAO_방금그곡 {
    public static void main(String[] args) {
        String[] musicinfos = {"03:30,04:00,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        KAKAO_방금그곡 kakao_방금그곡 = new KAKAO_방금그곡();
        System.out.println(kakao_방금그곡.solution("CC#BCC#BCC#BCC#B", musicinfos));
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";

        //잘못보고 G#처리를 안해줬어서 문제였다
        m = m.replace("C#", "c").replace("D#", "d")
                .replace("F#", "f").replace("A#", "a")
                .replace("G#", "g");

        int max = 0;
        for (String str : musicinfos) {
            String[] split = str.split(",");
            int dur = getDuration(split[0], split[1]);
            split[3] = split[3].replace("C#", "c").replace("D#", "d")
                    .replace("F#", "f").replace("A#", "a")
                    .replace("G#", "g");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < dur; i++) {
                sb.append(split[3].charAt(i % split[3].length()));
            }
            if (sb.toString().contains(m)) {
                if (dur > max) {
                    max = dur;
                    answer = split[2];
                }
            }
        }

        return answer;
    }

    //1차적으로 시간 계산하는 거에서 틀렸고
    private int getDuration(String start, String end){
        int hour = Integer.parseInt(end.split(":")[0]) - Integer.parseInt(start.split(":")[0]);
        int minute = Integer.parseInt(end.split(":")[1]) - Integer.parseInt(start.split(":")[1]) + (hour * 60);

        return minute;
    }
}
