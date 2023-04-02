import java.util.*;

public class MST_CF2 {
    static TreeSet<Integer>[] ar;
    static TreeSet<Integer> set;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ar = new TreeSet[n];
        for(int i = 0;i<n;i++) ar[i] = new TreeSet<>();
        for(int i = 0;i<m;i++){
            int a = sc.nextInt()-1;
            int b  =sc.nextInt()-1;
            ar[a].add(b);
            ar[b].add(a);
        }
        // for(HashSet<Integer> set:ar) System.out.println(set);
        set = new TreeSet<>();
        for(int i = 0;i<n;i++) set.add(i);
        int ans = 0;
        for(int i  =0;i<n;i++){
            if(set.remove(i)){
                ans++;
                dfs(i);
            }
        }
        System.out.println(ans-1);
    }
    public static void dfs(int x){
        List<Integer> l = new ArrayList<>();
        for(int i:set){
            if(!ar[x].contains(i)) l.add(i);
        }
        for(int i:l) set.remove(i);
        
        for(int i:l) dfs(i);
    }
}
