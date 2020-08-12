package basic.search;

public class DFS {
    private boolean visited[];
    private int answer=-1;
    private int target;
    public static void main(String[] args) {
        DFS dfs = new DFS();
        int[] input = {5, 6, 2, 8, 7, 23, 4, 1};
        dfs.init(input);
        dfs.target = 10;
        dfs.dfs(input, 0);
        if(dfs.answer==-1)
            System.out.println("찾고자 하는 원소가 없습니다.");
        else
            System.out.println(dfs.answer+1 + "번째 인덱스에 찾고자 하는 원소가 있습니다.");
    }
    private void init(int[] input){
        visited = new boolean[input.length];
    }
    private void dfs(int[] input, int n) {

        if(input[n] == target){
            answer = n;
            return;
        }

        if(visited[n])
            return;

        for(int i=0;i< input.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            dfs(input, i);
        }

    }
}
