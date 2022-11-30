import java.util.*;

public class Largest_Rec {
    public static int Find_Largest(int ar[]){
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i = 0;i<ar.length;i++){
            while(!s.isEmpty() && ar[i]<ar[s.peek()]){
                int h = ar[s.pop()];
                int r = i;
                if(s.isEmpty()) max = Math.max(max,h*r);
                else{
                    int l = s.peek();
                    max = Math.max(max,(r-l-1)*h);
                }
                
            }
            s.push(i);
        }
        int r = ar.length;
        while(!s.isEmpty()){
            int h = ar[s.pop()];
            if(s.isEmpty()){
                max = Math.max(max,h*r);
            }
            else {
                int l = s.peek();
                max = Math.max(max,h*(r-l-1));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int ar[] = {2,1,5,6,2,3};
        System.out.println(Find_Largest(ar));
    }
    
}
