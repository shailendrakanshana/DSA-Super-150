import java.util.*;

public class HouseRobber{
    //Recursive Approach
    public static int MaxProfit(int ar[],int i){
        if(i>=ar.length) return 0;
        //Recursive Approach
        int a = ar[i] + MaxProfit(ar, i+2);
        int b = MaxProfit(ar, i+1);
        return Math.max(a,b);
    }
    //Using Memoization
    int memo[];
    public int MaxProfit_Memo(int ar[], int i){
        if(i>=ar.length) return 0;
        if(memo[i]!=-1) return -1;
        //Storing Memo
        int a = ar[i] + MaxProfit(ar, i+2);
        int b = MaxProfit(ar, i+1);
        memo[i] = Math.max(a,b);
        return memo[i];
    }
    public int MaxProfit_Memo(int ar[]){
        memo = new int[ar.length];
        Arrays.fill(memo,-1);
        return MaxProfit(ar, 0);
    }
    //DP Bottom Up Appraoch
    public static int MaxProfit_DP(int ar[]){
        int n = ar.length;
        if(n==1) return ar[0];
        if(n==2) return Math.max(ar[0],ar[1]);
        //DP Array
        int dp[] = new int[n];
        dp[0] = ar[0];
        dp[1] = Math.max(ar[1],ar[0]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(ar[i]+dp[i-2],dp[i-1]);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        HouseRobber obj = new HouseRobber();
        int ar[] = {2,7,9,3,1};
        System.out.println(MaxProfit(ar, 0));   
        System.out.println(obj.MaxProfit_Memo(ar));
        System.out.println(MaxProfit_DP(ar));
    }
}