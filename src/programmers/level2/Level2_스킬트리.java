package programmers.level2;

import java.util.ArrayList;
import java.util.List;

public class Level2_스킬트리 {
    public static void main(String[] args) {
        String[] skill_trees = {"TAC"};
        Level2_스킬트리 level2_스킬트리 = new Level2_스킬트리();
        System.out.println(level2_스킬트리.solution("ABC", skill_trees));
    }

    public int solution(String skill, String[] skill_trees) {
        int res = 0;
        List<Character> list = new ArrayList<>();
        for(int i=0;i<skill.length();i++){
            list.add(skill.charAt(i));
        }

        for(int i=0;i<skill_trees.length;i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0;j<skill_trees[i].length();j++){
                if(list.contains(skill_trees[i].charAt(j))){
                    sb.append(skill_trees[i].charAt(j));
                }
            }
            if(skill.startsWith(sb.toString()))
                res ++;
        }
        return res;
    }
}
