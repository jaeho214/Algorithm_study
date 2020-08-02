package programmers.level3;

import java.util.ArrayList;
import java.util.List;

public class Level3_방문길이 {
    public static void main(String[] args) {
        Level3_방문길이 level3_방문길이 = new Level3_방문길이();
        System.out.println(level3_방문길이.solution("UDUDUDUDUDUDUDUDUDUDUDUDUDUDUD"));
    }
    private int x=0, y=0;
    private List<String> list = new ArrayList<>();
    public int solution(String dirs) {

        String dirArr[] = dirs.split("");
        for(String dir : dirArr){
            move(dir);
        }

        return list.size();
    }

    private void move(String dir) {
        String str = x + String.valueOf(y);

        if(dir.equals("U")){
            if(y==5)
                return;
            y ++;
        }else if(dir.equals("D")){
            if(y==-5)
                return;
            y --;
        }else if(dir.equals("L")){
            if(x==-5)
                return;
            x --;
        }else if(dir.equals("R")){
            if(x==5)
                return;
            x ++;
        }
        if(list.contains(str + x + y) ||
            list.contains(String.valueOf(x) + y + str)){
            return;
        }
        list.add(str + x + y);
    }
}
