public class LIS{
    //DP Appraoch Will give TLE for 10^5
    public static int find_LIS_DP(int ar[]){
        int dp[] = new int[ar.length];
        //O(N^2) Appraoch
        for(int i =0;i<ar.length;i++){
            dp[i] = 1;//Initially all the value will have a LIS value of 1
            for(int j = 0;j<i;j++){
                if(ar[j]<ar[i]) dp[i] = Math.max(dp[i],dp[j]+1);//Finding highest LIS less then ith value
            }
        }
        int max =0;
        for(int x:dp) max = Math.max(max,x);
        return max;
    }

    
    //Binary Search Appraoch O(Nlong(N))
    public static int find_LIS_BS(int ar[]){
        int dp[] = new int[ar.length];
        dp[0] = ar[0];
        int len = 1;
        for(int i = 1;i<ar.length;i++){
            if(ar[i]>dp[len-1]){
                dp[len] = ar[i];
                len++;
            }
            else{
                int ith = search(dp,0,len-1,ar[i]);
                dp[ith] = ar[i];
            }
        }
        return len;
    }
    public static int search(int ar[],int start,int end,int t){
        int left = start;
        int right = end;
        int mid=left - (left-right)/2;
        while(left<=right){
            if(ar[mid]<t) left  = mid+1;
            else right = mid-1;
            mid=left - (left-right)/2;
        }
        return mid;

    }

    public static void main(String[] args) {
        int ar[] = {10,9,2,5,3,7,101,18};
        System.out.println(find_LIS_DP(ar));  
        System.out.println(find_LIS_BS(ar)); 
    }
}