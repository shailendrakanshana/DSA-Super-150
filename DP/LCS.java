public class LCS {
    //USING DP MEMOIZATION
    int dp[][];
    public int LongestCommonSubsequence(String s,String r,int m,int n){
        if(dp[m][n]!=-1) return dp[m][n];
        if(m==0 || n==0) dp[m][n] = 0;
        else{
            if(s.charAt(m-1)==r.charAt(n-1)) dp[m][n]  = 1 + LongestCommonSubsequence(s, r,m-1,n-1);
            else dp[m][n] = Math.max(LongestCommonSubsequence(s, r, m-1, n),LongestCommonSubsequence(s, r, m, n-1));
        }
        return dp[m][n];
    }
    public int LongestCommonSubsequence(String s,String r){
        dp = new int[s.length()+1][r.length()+1];
        for(int i = 0;i<=s.length();i++){
            for(int j = 0;j<=r.length();j++) dp[i][j] = -1;
        }
        return LongestCommonSubsequence(s, r, s.length(), r.length());
    }

    //BOTTOM UP APPROACH
    public int LCS_DP(String s,String r){
        int dp[][] = new int[s.length()+1][r.length()+1];
        //Filling Bottom case
        //Because "abc" and "" the answer will be 0
        //Default zero filled in dp
        //Bottom up fill

        for(int i = 1;i<=s.length();i++){
            for(int j = 1;j<=r.length();j++){
                if(s.charAt(i-1)==r.charAt(j-1)) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[s.length()][r.length()];
    }
    public static void main(String[] args) {
        LCS obj = new LCS();
        System.out.println(obj.LongestCommonSubsequence("abcde", "ace"));
        System.out.println(obj.LCS_DP("abcde", "ace"));
    }
}
