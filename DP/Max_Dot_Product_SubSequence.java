import java.util.*;

public class Max_Dot_Product_SubSequence {
    //Recursion Memoization Appraoch
    //using Flag for base case handling -1 -1 , 1 1
    int memo[][];
    public int MDPS(int ar[],int br[],int m,int n,boolean flag){
        if(memo[m][n]!=-1) return memo[m][n];
        if(m==0 || n==0){
            if(flag) return 0;
            else return Integer.MIN_VALUE;
        }
        //Recursion call
        int nd = ar[m-1]*br[n-1] + MDPS(ar, br, m-1, n-1,true);
        int fd = MDPS(ar, br, m, n-1,flag);
        int sd = MDPS(ar, br, m-1, n,flag);
        memo[m][n] = Math.max(Math.max(nd,fd),sd);

        return memo[m][n];
    }
    public int MDPS(int ar[],int br[]){
        memo = new int[ar.length+1][br.length+1];
        //Filling -1
        for(int cr[]: memo) Arrays.fill(cr,-1);
        
        return MDPS(ar, br,ar.length,br.length,false);
        // if(res!=0) return res;
        // int max = Integer.MIN_VALUE;
        // for(int i = 0;i<ar.length;i++){
        //     for(int j = 0;j<br.length;j++){
        //         max = Math.max(max,ar[i]*br[j]);
        //     }
        // }
        // return max;
    }
    //using DP BOTTOM UP Appraoch
    public int MDPS_DP(int ar[],int br[]){
        int dp[][] = new int[ar.length+1][br.length+1];
        //LCS interative DP
        for(int i = 1;i<=ar.length;i++){
            for(int j = 1;j<=br.length;j++){
                //Simple recursion in interative
                dp[i][j] = Math.max(ar[i-1]*br[j-1]+dp[i-1][j-1],Math.max(dp[i-1][j],dp[i][j-1]));
            }
        }
        return dp[ar.length][br.length];
    }
    public int MDPS_DP_RN(int ar[],int br[]){
        int res = MDPS_DP(ar, br);
        if(res!=0) return res;
        //For 0 result any two with max product will be the answer
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<ar.length;i++){
            for(int j = 0;j<br.length;j++){
                max = Math.max(max,ar[i]*br[j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int ar[] = {3,-2};
        int br[] = {2,-6,7};
        Max_Dot_Product_SubSequence obj = new Max_Dot_Product_SubSequence();
        System.out.println(obj.MDPS(ar, br));
        System.out.println(obj.MDPS_DP_RN(ar, br));
    }
}
