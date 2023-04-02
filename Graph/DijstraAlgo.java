import java.util.*;

public class DijstraAlgo {
    HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
    class Dijstra_pairs{
        int vtx;
        String acq;
        int cost;
        public Dijstra_pairs(int vtx,String acq,int cost){
            this.vtx=vtx;
            this.acq=acq;
            this.cost=cost;
        }
        @Override
        public String toString(){
            return vtx+" vai "+acq+" @ "+cost;
            // return acq;
        }
    }
    public void Dijstra_algo(){
        PriorityQueue<Dijstra_pairs> pq=new PriorityQueue<>(new Comparator<Dijstra_pairs>() {

            @Override
            public int compare(DijstraAlgo.Dijstra_pairs o1, DijstraAlgo.Dijstra_pairs o2) {
                return o2.cost-o1.cost;
            }
           
        });
        HashSet<Integer> visited=new HashSet<>();
        pq.add(new Dijstra_pairs(1,"1",0));
        while(!pq.isEmpty()){
            Dijstra_pairs rv=pq.remove();
            if(visited.contains(rv.vtx)){
                continue;
            }
            visited.add(rv.vtx);
            System.out.println(rv);
            for(int nbrs:map.get(rv.vtx).keySet()){
                if(!visited.contains(nbrs)){
                    int cost=rv.cost+map.get(rv.vtx).get(nbrs);
                    pq.add(new Dijstra_pairs(nbrs,rv.acq+nbrs, cost));
                }
            }
        }
    }
}
