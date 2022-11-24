import java.util.*;

class Combinations {
    public void combinations(int ar[],int start,int k,List<Integer> l,List<List<Integer>> r){
        if(l.size()==k){
            r.add(new ArrayList<>(l));
        }
        for(int i = start;i<ar.length;i++){
            l.add(ar[i]);
            combinations(ar,i+1,k,l,r);
            l.remove(l.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> r = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int ar[] = new int[n];
        for(int i = 1;i<=n;i++){
            ar[i-1] = i;
        }
        combinations(ar,0,k,l,r);
        return r;
    }
    public static void main(String[] args) {
        Combinations obj = new Combinations();
        System.out.println(obj.combine(4,2));
    }
}