package leetCode;

import java.util.*;

public class Leetcode_721_Accounts_Merge_UNIONFIND {
    public static void main(String[] args) {
        Leetcode_721_Accounts_Merge_UNIONFIND accounts_merge = new Leetcode_721_Accounts_Merge_UNIONFIND();
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("Alex","Alex5@m.co","Alex4@m.co","Alex0@m.co"));
        accounts.add(Arrays.asList("Ethan","Ethan3@m.co","Ethan3@m.co","Ethan0@m.co"));
        accounts.add(Arrays.asList("Kevin","Kevin4@m.co","Kevin2@m.co","Kevin2@m.co"));
        accounts.add(Arrays.asList("Gabe","Gabe0@m.co","Gabe3@m.co","Gabe2@m.co"));
        accounts.add(Arrays.asList("Gabe","Gabe3@m.co","Gabe4@m.co","Gabe2@m.co"));
        System.out.println(accounts_merge.accountsMerge(accounts));
    }
    Map<String, String> map = new HashMap<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> answer = new ArrayList<>();
        Map<String, String> emailMap = new HashMap<>();

        //union-find를 하기 위해서 map에 노드들 저장
        for(List<String> account : accounts){
            for(int i=1;i<account.size();i++){
                if(!map.containsKey(account.get(i))){
                    map.put(account.get(i), account.get(i));
                }
                emailMap.put(account.get(i), account.get(0));
            }
        }

        //노드들을 union
        Map<String, List<String>> parents = new HashMap<>();
        for(List<String> account : accounts){
            for(int i=1;i<account.size()-1;i++){
                union(account.get(i), account.get(i+1));
            }
        }

        //가장 부모 노드를 키로 하고 자식들을 value로 하여 parents에 저장
        for(Map.Entry<String, String> entry : map.entrySet()){
            String parent = findParent(entry.getValue());
            List<String> emails = parents.getOrDefault(parent, new ArrayList<>());
            if(emails.isEmpty())
                parents.put(parent, new ArrayList<>());
            parents.get(parent).add(entry.getKey());
        }

        //parents를 돌면서 원하는 반환값으로 리턴
        for(Map.Entry<String, List<String>> entry : parents.entrySet()){
            List<String> list = entry.getValue();
            Collections.sort(list);
            List<String> tmp = new ArrayList<>();
            tmp.add(emailMap.get(entry.getKey()));
            tmp.addAll(list);
            answer.add(tmp);
        }


        return answer;
    }

    private void union(String a, String b) {
        String aParent = findParent(a);
        String bParent = findParent(b);

        map.put(aParent, bParent);
    }

    private String findParent(String search) {
        if(map.get(search).equals(search))
            return search;

        String parent = findParent(map.get(search));
        map.put(search, parent);
        return parent;
    }
}
