import java.util.*;

public class Bipartile_Graph {
    public boolean isValid(int graph[][]){
        HashMap<Integer,Integer> visited = new HashMap<>();
        Queue<BiPartilePair> q = new LinkedList<>();
        for(int src = 0;src<graph.length;src++){
            //For previously visited
            if(visited.containsKey(src)) continue;
            //BFS CODE
            q.add(new BiPartilePair(src, 0));
            while(!q.isEmpty()){
                BiPartilePair v = q.poll();
                if(visited.containsKey(v.vtx)){
                    if(visited.get(v.vtx) != v.lv) return false;
                    continue;
                }

                visited.put(v.vtx,v.lv);
                //Adding neightbours
                for(int nbrs:graph[v.vtx]){
                    if(!visited.containsKey(nbrs)) q.add(new BiPartilePair(nbrs, v.lv+1));
                }
            }
        }
        return true;
    }
    class BiPartilePair{
        int vtx;
        int lv;
        public BiPartilePair(int src,int lv){
            this.vtx = src;
            this.lv = lv;
        }
    }
}
