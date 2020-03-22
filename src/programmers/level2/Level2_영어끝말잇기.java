package programmers.level2;

import java.util.Stack;

public class Level2_영어끝말잇기 {
    public static void main(String[] args) {
        Level2_영어끝말잇기 level2_영어끝말잇기 = new Level2_영어끝말잇기();
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(level2_영어끝말잇기.solution(2, words));
    }
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        Stack<String> stack = new Stack<>();

        for(int i=0;i<words.length;i++){
            if(stack.isEmpty()) {
                stack.push(words[i]);
                continue;
            }
            if(stack.contains(words[i]) || !stack.peek().endsWith(String.valueOf(words[i].charAt(0)))){
                answer[0] = (i%n)+1;
                answer[1] = (i/n)+1;
                break;
            }
            stack.push(words[i]);
        }

        return answer;
    }
}
