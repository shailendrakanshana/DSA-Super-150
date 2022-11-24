import java.util.List;

public class generateParanthesis {
    public static void generate(int n,int open ,int close,String ans){
        if(open==n && close==n){
            System.out.println(ans);
        }
        if(open<n){
            generate(n, open+1, close, ans+"(");
        }
        if(close<open){
            generate(n, open, close+1, ans+")");
        }
    }
    public static void main(String[] args) {
        generate(3, 0, 0, "");
    }
    
}
