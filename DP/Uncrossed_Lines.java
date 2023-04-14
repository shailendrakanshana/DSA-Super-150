public class Uncrossed_Lines {
    //SAME QUESTION LCS APPILIED ON ARRAY
    //TABLE fill appraoch
    public static int Uncrossed_Lines_DP(int ar[],int br[]){
        int dp[][] = new int[ar.length+1][br.length+1];
        //Filling base condition
        //DEFAULT 0 filled in array dp for r = 0 or c = 0
        for(int i = 1;i<=ar.length;i++){
            for(int j = 1;j<=br.length;j++){
                if(ar[i-1]==br[j-1]) dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[ar.length][br.length];
    }
    public static void main(String[] args) {
        int ar[] = {2,5,1,2,5};
        int br[] = {10,5,2,1,5,2};
        System.out.println(Uncrossed_Lines_DP(ar, br));
    }
}
