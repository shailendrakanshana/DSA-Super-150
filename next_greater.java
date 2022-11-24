import java.util.*;

public class next_greater {
    public static List<Integer> find_next_Greater(int ar[]){
        Stack<Integer> s = new Stack<>();
        int n = ar.length;
        s.push(ar[n-1]);
        List<Integer> l = new ArrayList<>();
        l.add(-1);
        int r = -1;
        for(int i = n-2;i>=0;i--){
            if(s.peek()>ar[i]){
                r = s.peek();
                l.add(r);
            }
            else{
                if(ar[i]>r){
                    r = ar[i];
                    l.add(-1);
                }
                else{
                    l.add(r);
                }
            }
            s.push(ar[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = n-1;i>=0;i--) ans.add(l.get(i));
        return ans;

    }
    public static void main(String[] args) {
        int ar[] = {10,2,1,3,5,4,8,7};
        System.out.println(find_next_Greater(ar));
    }
    
}
