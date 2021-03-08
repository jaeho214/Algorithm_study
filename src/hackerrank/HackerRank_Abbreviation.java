package hackerrank;

public class HackerRank_Abbreviation {
    public static void main(String[] args) {
        System.out.println(abbreviation("daBcd", "ABC"));
    }

    static String abbreviation(String a, String b) {


        boolean[][] dp = new boolean[a.length()+1][b.length()+1];
        dp[0][0] = true;


        for(int i=1;i<a.length()+1;i++){
            for(int j=0;j<b.length()+1;j++){
                //이전 문자열까지 가능했고, 이번 문자열도 같다면 가능
                if(j>0 && dp[i-1][j-1] && isEqual(a.charAt(i-1), b.charAt(j-1)))
                    dp[i][j] = true;

                //이번 문자열이 소문자고, 이전 문자열까지 가능했다면 이번 문자를 지우면 된다. 지우면 가능
                if(Character.isLowerCase(a.charAt(i-1)) &&  dp[i-1][j])
                    dp[i][j] = true;
            }
        }

        return dp[a.length()][b.length()] ? "YES" : "NO";
    }

    private static boolean isEqual(char a, char b) {
        return Character.toLowerCase(a) == Character.toLowerCase(b);
    }

}
