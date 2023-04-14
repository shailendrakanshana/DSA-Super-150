import java.util.*;

public class Decode_Ways {
    //Simple recursion appraoch
    int memo[];
    public int NDW(int start,String s){
        if(start==s.length()) return 1;
        if(s.charAt(start)=='0') return 0;
        if(start==s.length()-1) return 1;
        //Memoization
        if(memo[start]!=-1) return memo[start];
        //Recursive calls
        int one = NDW(start+1,s);
        //For two
        int two = 0;
        int b = Integer.valueOf(""+s.charAt(start)+s.charAt(start+1));
        //Checking for A-Z
        if(b>=1 && b<=26) two = NDW(start+2,s);
        memo[start] = one+two;
        return memo[start];
    }
    public int numDecodings(String s) {
        memo = new int[s.length()];
        Arrays.fill(memo,-1);
        return NDW(0,s);
    }
    public static void main(String[] args) {
        Decode_Ways obj = new Decode_Ways();
        System.out.println(obj.numDecodings("226"));
    }
}
