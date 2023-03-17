import java.util.*;

public class Graph{
    private HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();

    public Graph(int v){
        for(int i =1;i<=v;i++){
            map.put(i,new HashMap<>());
        }
    }

    public void AddEdge(int v1,int v2,int cost){
        //Adding for all values
        map.get(v1).put(v2,cost);
        map.get(v2).put(v1,cost);
    }
    public boolean contains(int v1,int v2){
        if(!map.containsKey(v1) || !map.containsKey(v2)) return false;
        return map.get(v1).containsKey(v2) && map.get(v2).containsKey(v1);
    }

    public int noofEdges(){
        int ans = 0;
        for(int key:map.keySet()){
            ans = ans + map.get(key).size();
        }
        return ans/2;
    }
    public void RemoveEdge(int v1,int v2){
        map.get(v1).remove(v2);
        map.get(v2).remove(v1);
    }
    public void RemoveVertex(int v){
        if(!map.containsKey(v)) return;
        for(int key:map.get(v).keySet()){
            map.get(key).remove(v);
        }
        map.remove(v);
    }
    //HasPath function
    //To Avoid recheckability loop using memoization
    public boolean hasPath(int src,int dest){
        return hasPath(src, dest, new HashSet<>());
    }
    public boolean hasPath(int src,int dest,HashSet<Integer> visited){
        if(src==dest) return true;
        visited.add(src);
        for(int key:map.get(src).keySet()){
            if(visited.contains(key)) continue;
            boolean ans = hasPath(key, dest,visited);
            if(ans) return true;
        }
        visited.remove(src);
        return false;
    }
    //Display Function 
    public void Display(){
        for(int key:map.keySet()){
            System.out.println(key+" "+map.get(key));
        }
    }
    //All path print method
    public void PrintAllPath(int src,int dest){
        PrintAllPath(src, dest,new HashSet<>(),"");
    }
    public void PrintAllPath(int src,int dest,HashSet<Integer> visited,String path){
        if(src==dest){
            System.out.println(path+dest);
            return;
        }
        visited.add(src);
        for(int key:map.get(src).keySet()){
            if(visited.contains(key)) continue;
            PrintAllPath(key, dest, visited, path+src);
            //Adding path to src because of we have to add the values which are present in set;
        }
        visited.remove(src);
    }

    //BFS in Graph
    public boolean BFS(int src,int dest){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()){
            //
            int v = q.poll();
            if(visited.contains(v)) continue;

            visited.add(v);
            if(v==dest) return true;
            //Adding neightbours
            for(int nbrs:map.get(v).keySet()){
                if(!visited.contains(nbrs)) q.add(nbrs);
            }
        }
        return false;
    }

    //DFS in Graph
    public boolean DFS(int src,int dest){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        stk.push(src);
        while(!stk.isEmpty()){
            int v = stk.pop();

            if(visited.contains(v)) continue;

            visited.add(v);
            if(v==dest) return true;
            for(int nbrs:map.get(v).keySet()){
                if(!visited.contains(nbrs)) stk.push(nbrs);
            }
        }
        return false;
    }
    //BF Traversal
    public void BFT(){
        HashSet<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int src:map.keySet()){
            //For previously visited
            if(visited.contains(src)) continue;
            //BFS CODE
            q.add(src);
            while(!q.isEmpty()){
                int v = q.poll();
                if(visited.contains(v)) continue;

                visited.add(v);
                System.out.print(v+" ");
                //Adding neightbours
                for(int nbrs:map.get(v).keySet()){
                    if(!visited.contains(nbrs)) q.add(nbrs);
                }
            }
        }
    }
    //DF Traversal
    public void DFT(){
        HashSet<Integer> visited = new HashSet<>();
        Stack<Integer> stk = new Stack<>();
        for(int src:map.keySet()){
            //For Previously Visited
            if(visited.contains(src)) continue;
            //DFS Code
            stk.push(src);
            while(!stk.isEmpty()){
                int v = stk.pop();

                if(visited.contains(v)) continue;

                visited.add(v);
                System.out.print(v+" ");
                for(int nbrs:map.get(v).keySet()){
                    if(!visited.contains(nbrs)) stk.push(nbrs);
                }
            }
        }
    }

}