package kakao.blind2019;

import java.util.*;

public class KAKAO_길찾기게임 {
    public Tree root;
    public class Pair implements Comparable<Pair>{
        int x;
        int y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.y < o.y){
                return 1;
            }else if(this.y > o.y){
                return -1;
            }else{
                if(this.x > o.x){
                    return 1;
                }else{
                    return -1;
                }
            }
        }
    }
    public class Tree{
        private int data;
        private Tree left;
        private Tree right;

        public Tree(){
        }

        public Tree(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        //트리 노드 추가
        public void insert(int num){
            Tree tree = new Tree(num);
            if(root == null){
                root = tree;
                return;
            }
            Tree current = root;
            Tree parent = null;
            while(true){
                parent = current;
                //왼쪽으로 넣을 수 있다면 왼쪽으로
                if(num < current.data){
                    current = current.left;
                    if(current == null){
                        parent.left = tree;
                        return;
                    }
                //오른쪽으로 넣을 수 있다면 오른쪽으로
                }else {
                    current = current.right;
                    if(current == null){
                        parent.right = tree;
                        return;
                    }
                }
            }
        }

    }
    public static void main(String[] args) {
        int[][] node = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        KAKAO_길찾기게임 kakao_길찾기게임 = new KAKAO_길찾기게임();
        System.out.println(kakao_길찾기게임.solution(node));
    }

    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        Tree tree = new Tree();
        List<Pair> list = new ArrayList<>();
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for(int i=0;i<nodeinfo.length;i++){
            list.add(new Pair(nodeinfo[i][0], nodeinfo[i][1]));
            //x는 겹칠 수 없다는 조건이 있었으므로 키를 x로 value를 인덱스로 맵에 저장
            //x를 통해서 트리를 만들건데 순회는 인덱스값으로 해줘야하기 때문
            map.put(nodeinfo[i][0], i+1);
        }
        list.sort(Pair::compareTo);

        for(Pair i : list){
            //x값으로 트리를 만들어주고
            tree.insert(i.x);
        }

        //순회
        preOrder(root, map, preOrder);
        postOrder(root, map, postOrder);

        for(int i=0;i<nodeinfo.length;i++){
            answer[0][i] = preOrder.get(i);
            answer[1][i] = postOrder.get(i);
        }
        return answer;
    }
    public void preOrder(Tree tree, Map<Integer, Integer> map, List<Integer> result){
        if(tree!=null){
            //x값이 트리에 들어가있으므로 x값의 인덱스 값을 map에서 꺼내서 리스트에 저장
            result.add(map.get(tree.data));
            preOrder(tree.left, map, result);
            preOrder(tree.right, map, result);
        }
    }

    public void postOrder(Tree tree, Map<Integer, Integer> map, List<Integer> result){
        if(tree != null){
            postOrder(tree.left, map, result);
            postOrder(tree.right, map, result);
            result.add(map.get(tree.data));
        }
    }
}
