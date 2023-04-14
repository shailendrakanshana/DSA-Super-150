import java.util.*;

public class LPS {
    //DP MEMOIZATION
    int memo[][];
    public int LPS_MEMO(String s,int left,int right){
        //Base conditions
        if(left>right) return 0;
        if(left==right) return 1;
        if(memo[left][right]!=-1) return memo[left][right];
        //Recursive calls
        if(s.charAt(left)==s.charAt(right)) memo[left][right] = 2 + LPS_MEMO(s,left+1,right-1);
        else memo[left][right] = Math.max(LPS_MEMO(s,left+1,right),LPS_MEMO(s,left,right-1));

        return memo[left][right];
    }
    public int longestPalindromeSubseq(String s) {
        //MEMO array
        memo = new int[s.length()][s.length()];
        //Filling with -1
        for(int ar[]: memo) Arrays.fill(ar,-1);

        return LPS_MEMO(s,0,s.length()-1);
    }
    public static void main(String[] args) {
        LPS obj = new LPS();
        System.out.println(obj.longestPalindromeSubseq("bbbab"));

    }
}
