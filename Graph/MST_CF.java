import java.util.*;

public class MST_CF {
    private HashMap<Integer,HashSet<Integer>> map = new HashMap<>();

    public MST_CF(int v){
        for(int i =1;i<=v;i++){
            map.put(i,new HashSet<>());
        }
    }

    public void AddEdge(int v1,int v2){
        //Adding for all values
        map.get(v1).add(v2);
        map.get(v2).add(v1);
    }

    class PrimsPair{
        int src;
        int dest;
        int cost;
        PrimsPair(int src,int dest,int cost){
            this.src = src;
            this.dest = dest;
            this.cost = cost;
        }
    }

    public int Prims(){
        int n = map.size();
        PriorityQueue<PrimsPair> q = new PriorityQueue<>(new Comparator<PrimsPair>() {
            @Override
            public int compare(PrimsPair a,PrimsPair b){
                return a.cost-b.cost;
            }
        });
        int Total_cost = 0;
        q.add(new PrimsPair(1, 1, 0));
        HashSet<Integer> visited = new HashSet<>();
        while(!q.isEmpty()){
            PrimsPair v = q.poll();
            if(visited.contains(v.dest)) continue;

            visited.add(v.dest);
            Total_cost = Total_cost + v.cost;
            for(int nbrs = 1;nbrs<=n;nbrs++){
                if(!visited.contains(nbrs)){
                    int cost = 0;
                    if(map.get(v.dest).contains(nbrs)) cost = 1;
                    q.add(new PrimsPair(v.dest, nbrs, cost));
                }
            }
        }
        return Total_cost;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        MST_CF graph = new MST_CF(n);
        for(int i = 0;i<m;i++){
            int a  = sc.nextInt();
            int b = sc.nextInt();
            graph.AddEdge(a, b);
        }
        System.out.println(graph.Prims());
    }
}
