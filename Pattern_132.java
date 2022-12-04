import java.util.Stack;

public class Pattern_132 {
    public static boolean Pattern132(int ar[]){
        int n = ar.length;
        int min[] = new int[n];
        min[0] = ar[0];
        for(int i = 1;i<n;i++){
            min[i] = Math.min(min[i-1],ar[i]);
        }
        Stack<Integer> stk = new Stack<>();
        for(int j  = n-1;j>=0;j--){
            int ith = min[j];
            while(!stk.isEmpty() && ith>=ar[stk.peek()]){
                stk.pop();
            }
            if(!stk.isEmpty() && ar[j]>ar[stk.peek()]) return true;
            stk.push(j);
        }
        return false;

    }
    public static void main(String[] args) {
        
    }
    
}
