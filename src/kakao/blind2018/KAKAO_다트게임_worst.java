package kakao.blind2018;

import java.util.ArrayList;
import java.util.List;

public class KAKAO_다트게임_worst {
    public static void main(String[] args) {
        KAKAO_다트게임_worst kakao_다트게임Worst = new KAKAO_다트게임_worst();
        System.out.println(kakao_다트게임Worst.solution("1D2S10T"));
    }

    public int solution(String dartResult) {
        int answer = 0;
        List<String> scoreList = getScoreList(dartResult);
        int[] scoreArr = new int[scoreList.size()];
        for(int i=0; i<scoreList.size(); i++){
            char[] split = new char[scoreList.get(i).length()];
            for(int j=0;j<scoreList.get(i).length(); j++){
                split[j] = scoreList.get(i).charAt(j);
            }
            if(scoreList.get(i).contains("*") || scoreList.get(i).contains("#")){
                if(split[2] == '*'){
                    scoreArr[i] = getScore(split[0]-'0', split[1]);
                    scoreArr[i] *= 2;
                    if(i==0)
                        continue;
                    scoreArr[i-1]  *= 2;
                }else if(split[2] == '#'){
                    scoreArr[i] = getScore(split[0]-'0', split[1]);
                    scoreArr[i] *= -1;
                }
            }else{
                if(split.length == 3){
                    scoreArr[i] = getScore(10, split[2]);
                }else if(split.length==2){
                    scoreArr[i] = getScore(split[0]-'0', split[1]);
                }
            }
        }
        for(int i=0;i<scoreArr.length;i++){
            answer += scoreArr[i];
        }
        return answer;
    }

    public List<String> getScoreList(String dartResult){
        List<String> scoreList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        sb.append(dartResult.charAt(0));
        for(int i=1;i<dartResult.length();i++){
            char ch = dartResult.charAt(i);
            if(ch-'0' ==0 && dartResult.charAt(i-1)-'0' == 1){
                sb.append(dartResult.charAt(i));
                continue;
            }
            if(Character.isDigit(ch)){
                scoreList.add(sb.toString());
                sb = new StringBuilder();
            }
            sb.append(dartResult.charAt(i));
        }
        scoreList.add(sb.toString());

        return scoreList;
    }

    public int getScore(int num, char result){
        switch (result){
            case 'S':
                return (int) Math.pow(num, 1);
            case 'D':
                return  (int) Math.pow(num, 2);
            case 'T':
                return  (int) Math.pow(num, 3);
        }
        return 0;
    }
}
