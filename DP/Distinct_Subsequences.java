
//COIN CHANGE 2 - APPRAOCH
public class Distinct_Subsequences {
    //Recursive Appraoch
    public int findSubs(String s,String t,int i,int j){
        //Base condition
        if(j==t.length()) return 1;
        if(i==s.length()) return 0;
        int inc = 0;
        int exc  =0;
        if(s.charAt(i)==t.charAt(j)) inc = findSubs(s, t, i+1, j+1);
        exc = findSubs(s, t, i+1, j);
        
        return inc+exc;
    }
    //DP Appraoch
    public int findSubs(String s,String t){
        int dp[][] = new int[s.length()+1][t.length()+1];
        for(int i =0;i<=s.length();i++) dp[i][0] = 1;
        //DP Iteration
        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=t.length();j++){
                int inc = 0;
                int exc = 0;
                if(s.charAt(i-1)==t.charAt(j-1)) inc = dp[i-1][j-1];
                exc = dp[i-1][j];
                dp[i][j] = inc+exc;
            }
        }

        return dp[s.length()][t.length()];
    }
    public static void main(String[] args) {
        Distinct_Subsequences obj = new Distinct_Subsequences();
        String s = "rabbbit";
        String t = "rabbit";
        System.out.println(obj.findSubs(s, t, 0, 0));
        System.out.println(obj.findSubs(s, t));
    }
}
