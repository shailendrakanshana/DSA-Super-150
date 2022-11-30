import java.util.*;

public class Construct_SmallestNumber_DI {
    public static String smallestNumber(String s) {
        int ans[] = new int[s.length()+1];
        Stack<Integer> stk = new Stack<>();
        int c  = 1;
        for(int i = 0;i<=s.length();i++){
            if(i==s.length() || s.charAt(i)=='I'){
                ans[i] = c++;
                while(!stk.isEmpty()){
                    ans[stk.pop()] = c++;
                }
            }
            else{
                stk.push(i);
            }
            
        }
        String str = "";
        for(int i = 0;i<ans.length;i++){
            str = str + ans[i];
        }
        return str;
    }
    public static void main(String[] args) {
        System.out.println(smallestNumber("IIIDIDDD"));
    }
    
}
