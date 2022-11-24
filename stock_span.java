import java.util.*;

public class stock_span {
    public static void stockSpan(int ar[]){
        int n = ar.length;
        int ans[] = new int[n];
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<n;i++){
            while(!s.isEmpty() && ar[i]>ar[s.peek()]) s.pop();
            if(!s.isEmpty()) ans[i] = i-s.peek();
            else ans[i] = i+1;
            s.push(i);
        }
        
        for(int i = 0;i<n;i++) System.out.print(ans[i]+" ");
    }
    public static void main(String[] args) {
        int ar[] = {30,35,40,38,35};
        stockSpan(ar);
    }
    
}
