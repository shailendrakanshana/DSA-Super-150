import java.util.*;

public class Sliding_Window_Max {
    public static int[] find_Max_Window(int ar[],int k){
        int n = ar.length;
        Deque<Integer> dq = new LinkedList<>();
        for(int i = 0;i<k;i++){
            while(!dq.isEmpty() && ar[i]>ar[dq.getLast()]){
                dq.removeLast();
            }
            dq.add(i);
        }
        int ans[] = new int[n-k+1];
        ans[0] = ar[dq.getFirst()];
        for(int i =k;i<n;i++){
            while(!dq.isEmpty() && ar[i]>ar[dq.getLast()]){
                dq.removeLast();
            }
            dq.add(i);
            if(!dq.isEmpty() && dq.getFirst()==i-k){
                dq.removeFirst();
            }
            ans[i-k+1] = ar[dq.getFirst()];
        }
        return ans;

    }
    public static void main(String[] args) {
        int ar[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int br[] = find_Max_Window(ar, k);
        for(int i = 0;i<br.length;i++) System.out.print(br[i]+" ");
    }
}
