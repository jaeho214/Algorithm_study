package programmers.level3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Level3_길찾기게임 {
    public static void main(String[] args) {
        Level3_길찾기게임 level3_길찾기게임 = new Level3_길찾기게임();
        int[][] nodeInfo = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        System.out.println(level3_길찾기게임.solution(nodeInfo));
    }
    public Node root;

    public class Node{
        private Pair data;
        private Node left;
        private Node right;

        public Node(Pair data){
            this.data = data;
            this.left = null;
            this.right = null;
        }

        public void add(Pair data){
            Node node = new Node(data);
            if(root == null){
                root = node;
                return;
            }
            Node current = root;
            while(true){
                Node parent = current;
                if(data.x < current.data.x){
                    current = current.left;
                    if(current == null){
                        parent.left = node;
                        return;
                    }
                }else{
                    current = current.right;
                    if(current == null){
                        parent.right = node;
                        return;
                    }
                }
            }

        }

    }
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        int num;

        public Pair(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.y < o.y)
                return 1;
            else if(this.y > o.y)
                return -1;
            else{
                if(this.x < o.x)
                    return -1;
                else if(this.x > o.x)
                    return 1;
                return 0;
            }
        }
    }
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];

        List<Pair> list = new ArrayList<>();

        for(int i=0;i<nodeinfo.length;i++){
            list.add(new Pair(nodeinfo[i][0], nodeinfo[i][1], i+1));
        }

        Collections.sort(list);

        for(int i=0; i<list.size();i++){
            if(i==0){
                root = new Node(list.get(i));
                continue;
            }
            root.add(list.get(i));
        }

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        preOrder(root, preOrder);
        postOrder(root, postOrder);

        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preOrder.get(i);
            answer[1][i] = postOrder.get(i);
        }

        return answer;
    }

    private void preOrder(Node node, List<Integer> list){
        if(node == null)
            return;
        list.add(node.data.num);
        preOrder(node.left, list);
        preOrder(node.right, list);
    }


    private void postOrder(Node node, List<Integer> list){
        if(node == null)
            return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.data.num);
    }
}
