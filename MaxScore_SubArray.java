import java.util.*;

public class MaxScore_SubArray {
    public static int Find_Largest(int ar[],int k){
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i = 0;i<ar.length;i++){
            while(!s.isEmpty() && ar[i]<ar[s.peek()]){
                int h = ar[s.pop()];
                int r = i;
                if((r-1)>=k){
                    if(s.isEmpty()) max = Math.max(max,h*r);
                    else{
                        int l = s.peek();
                        if(l+1<=k){
                            max = Math.max(max,(r-l-1)*h);
                        }
                    }
                }
                
            }
            s.push(i);
        }
        int r = ar.length;
        while(!s.isEmpty()){
            int h = ar[s.pop()];
            if(r-1>=k){
                if(s.isEmpty()){
                    max = Math.max(max,h*r);
                }
                else {
                    int l = s.peek();
                    if(l+1<=k){
                        max = Math.max(max,h*(r-l-1));
                    }
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int ar[] = {1,4,3,7,4,5};
        System.out.println(Find_Largest(ar,3));
    }
    
}
