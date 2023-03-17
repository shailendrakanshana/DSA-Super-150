import java.util.*;

public class Graph_Valid_Tree {
    public boolean validTree(int n, int[][] edges) {
        //HashMap Appraoch
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            map.put(i,new ArrayList<>());
        }
        for(int i = 0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            map.get(a).add(b);
            map.get(b).add(a);
        }
        return isValid(map);
    }
    //DFT code
    public boolean isValid(HashMap<Integer,List<Integer>> map){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        int count = 0;
        for(int src:map.keySet()){
            //For Previously Visited
            if(visited.contains(src)) continue;
            count++;
            //DFS Code
            stk.push(src);
            while(!stk.isEmpty()){
                int v = stk.pop();

                if(visited.contains(v)) return false;

                visited.add(v);
                for(int nbrs:map.get(v)){
                    if(!visited.contains(nbrs)) stk.push(nbrs);
                }
            }
        }
        if(count<=1) return true;
        return false;
    }
}
