import java.util.*;

public class Insert_down {
    public static void Insert(Stack<Integer> s,int x){
        if(s.isEmpty()) s.push(x);
        else{
            int a = s.pop();
            Insert(s, x);
            s.push(a);
        }
    }
    public static void reverse(Stack<Integer> s){
        if(s.isEmpty()) return ;
        int a = s.pop();
        reverse(s);
        Insert(s, a);
    }
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        System.out.println(s);
        Insert(s,-3);
        System.out.println(s);
        reverse(s);
        System.out.println(s);
    }
    
}
