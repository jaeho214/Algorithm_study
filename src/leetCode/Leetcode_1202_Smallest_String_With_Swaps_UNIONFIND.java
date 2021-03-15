package leetCode;

import java.util.*;

public class Leetcode_1202_Smallest_String_With_Swaps_UNIONFIND {
    public static void main(String[] args) {
        Leetcode_1202_Smallest_String_With_Swaps_UNIONFIND smallest_string_with_swaps = new Leetcode_1202_Smallest_String_With_Swaps_UNIONFIND();
        List<List<Integer>> pairs =new ArrayList<>();
        List<Integer> list1 = Arrays.asList(0, 3);
        List<Integer> list2 = Arrays.asList(1, 2);
        pairs.add(list1);
        pairs.add(list2);
        System.out.println(smallest_string_with_swaps.smallestStringWithSwaps("dcab", pairs));
    }

    public int findParent(int search){
        if(parent[search] == search)
            return search;

        return parent[search] = findParent(parent[search]);
    }

    public void unionParent(int a, int b){
        int aParent = findParent(a);
        int bParent = findParent(b);


        parent[aParent] = bParent;
    }

    int[] parent = new int[100001];

    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if(s.length() == 0 || pairs.isEmpty())
            return s;

        int len = s.length();

        for(int i=0;i<100001;i++){
            parent[i] = i;
        }

        //pairs를 union-find를 통해서 바꿀 수 있는 인덱스끼리 묶는다.
        //예를 들어 [0,1], [1,2] 는 0,1,2 끼리 연결되어 있기때문에 모두 바꿀 수 있다.
        //[0,3], [1,2]는 1,2끼리만 바꿀 수 있고 0,3끼리만 바꿀 수 있다.
        for(List<Integer> pair : pairs){
            unionParent(pair.get(0), pair.get(1));
        }

        Map<Integer, List<Integer>> idxMap = new HashMap<>();

        //String을 돌면서
        for(int i=0;i<len;i++){
            //각 인덱스의 부모 모드를 키값으로 해서 인덱스의 리스트를 저장한다.
            int parent = findParent(i);
            List<Integer> idxList = idxMap.getOrDefault(parent, new ArrayList<>());
            if(idxList.isEmpty())
                idxMap.put(parent, idxList);
            idxList.add(i);
        }

        char[] res = new char[len];
        //idxMap을 돌면서
        for(Map.Entry<Integer, List<Integer>> idxEntry : idxMap.entrySet()){
            //한 노드와 바꿀 수 있는 모든 노드들을 얻고
            List<Integer> idxList = idxEntry.getValue();
            char[] tmp = new char[idxList.size()];

            //노드들의 값을 tmp 배열에 저장한 후
            int c = 0;
            for(int idx : idxList){
                tmp[c++] = s.charAt(idx);
            }

            //tmp 배열을 오름차순으로 정렬한다.
            //tmp에는 바뀔 수 있는 노드들만 들어간다.
            //그러므로 오름차순으로 정렬하면 노드끼리 바꿔서 만들 수 있는 최소 값이 나온다.
            Arrays.sort(tmp);

            //이를 res의 배열의 그 노드 자리에 배치시켜준다.
            for(int i=0;i<tmp.length;i++){
                res[idxList.get(i)] = tmp[i];
            }
        }

        return String.valueOf(res);
    }
}
