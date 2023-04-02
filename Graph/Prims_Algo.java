import java.util.*;

public class Prims_Algo {
    class Prim_Pair{
        int src;
        int dest;
        int cost;
        Prim_Pair(int src,int dest,int cost){
            this.dest = dest;
            this.src = src;
            this.cost = cost;
        }
    }
    public void Prims(HashMap<Integer,HashMap<Integer,Integer>> map){
        PriorityQueue<Prim_Pair> q = new PriorityQueue<>(new Comparator<Prim_Pair>() {
            @Override
            public int compare(Prim_Pair a,Prim_Pair b){
                return a.cost-b.cost;
            }
        });
        HashSet<Integer> visited = new HashSet<>();
        q.add(new Prim_Pair(1, 1, 0));
        while(!q.isEmpty()){
            Prim_Pair v = q.poll();
            if(visited.contains(v.dest)) continue;
            visited.add(v.dest);
            System.out.println(v.src+" --> "+v.dest+" $"+v.cost);
            for(int nbrs:map.get(v.dest).keySet()){
                if(!visited.contains(nbrs)){
                    int cost = map.get(v.dest).get(nbrs);
                    q.add(new Prim_Pair(v.dest, nbrs, cost));
                }
            }
        }


    }
    public static void main(String[] args) {
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int n  =sc.nextInt();
        int m = sc.nextInt();
        for(int i = 1;i<=n;i++) map.put(i,new HashMap<>());
        for(int i = 0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            map.get(a).put(b,c);
            map.get(b).put(a,c);
        }
        Prims_Algo obj = new Prims_Algo();
        obj.Prims(map);
        sc.close();

    }

    
}
