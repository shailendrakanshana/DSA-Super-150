public class Coin_Change2 {
    //Recursuve Appraoch
    public int findWays(int ar[],int amount,int start){
        if(amount==0) return 1;
        if(start==ar.length) return 0;
        int inc = 0;
        int exc = 0;
        if(ar[start]<=amount){
            inc = findWays(ar, amount-ar[start], start);
        }
        exc = findWays(ar, amount, start+1);
        return inc+exc;
    }
    //DP Approach
    public int findWays(int ar[],int amount){
        //2D Dp array for coins
        int dp[][] = new int[ar.length+1][amount+1];
        //Filling with 1 for all coins
        for(int i = 0;i<=ar.length;i++) dp[i][0] = 1;

        for(int i = 1;i<=ar.length;i++){
            for(int j = 1;j<=amount;j++){
                int inc = 0;
                int exc = 0;
                //As same as recursion call
                if(ar[i-1]<=j) inc = dp[i][j-ar[i-1]];
                exc = dp[i-1][j];

                dp[i][j] = inc+exc;
            }
        }
        return dp[ar.length][amount];
    }
    public static void main(String[] args) {
        Coin_Change2 obj = new Coin_Change2();
        int ar[] = {1,2,5};
        int amount = 5;
        System.out.println(obj.findWays(ar, amount, 0));
        System.out.println(obj.findWays(ar, amount));
    }
}
