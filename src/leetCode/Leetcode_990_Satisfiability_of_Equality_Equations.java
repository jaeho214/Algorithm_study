package leetCode;

public class Leetcode_990_Satisfiability_of_Equality_Equations {
    public static void main(String[] args) {
        Leetcode_990_Satisfiability_of_Equality_Equations satisfiability_of_equality_equations = new Leetcode_990_Satisfiability_of_Equality_Equations();
        String[] equations = {"q==j","d!=n","u==a","o!=e","e==l","q==s","q!=h","h!=w","q!=n","k==q","m==k","h!=u","l==i","b!=d","a!=x","c==h","f!=k","r==u","o!=r","n!=t","p==n","o!=m","m!=w","b!=f","h!=o","v==v","j!=b","k!=n","w!=a","i!=x","o!=q","u!=n","i!=c","q!=c","p!=f","u!=t","a==r","h!=k","y==y","r==o"};
        System.out.println(satisfiability_of_equality_equations.equationsPossible(equations));
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

    int[] parent = new int[26];
    public boolean equationsPossible(String[] equations) {

        for(int i=0;i<26;i++){
            parent[i] = i;
        }

        //"==" 먼저 이어놓고
        for(String equation : equations){
            String[] split = equation.split("");
            if(split[1].charAt(0) == '=')
                unionParent(split[0].charAt(0)-'a', split[3].charAt(0)-'a');
        }

        //"!="를 확인하다가 모순이 발생하면 false
        for(String equation : equations){
            String[] split = equation.split("");
            if(split[1].charAt(0) == '!' && findParent(split[0].charAt(0)-'a') == findParent(split[3].charAt(0)-'a'))
                    return false;

        }

        return true;
    }
}
