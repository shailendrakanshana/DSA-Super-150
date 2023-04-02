import java.util.*;

public class DSU {
    class Node{
        int vtx;
        Node parent;
        int rank;
    }
    HashMap<Integer,Node> map = new HashMap<>();

    public void CreateSet(int v){
        Node node = new Node();
        node.vtx = v;
        node.parent = node;
        node.rank = 0;

        map.put(v,node);
    }

    public int find(int v){
        Node nn = map.get(v);
        return find(nn).vtx;
    }
    //Simple recursion appraoch
    // private Node find(Node nn){
    //     if(nn.parent==nn) return nn;
    //     return find(nn.parent); //ORIGINAL CODE NON - OPTIMIZED CODE
    // }
    private Node find(Node nn){
        if(nn.parent==nn) return nn;
        Node prnt = find(nn.parent);
        nn.parent = prnt;
        return prnt;
    }
    
    //Union function
    public void Union(int v1,int v2){
        Node n1 = map.get(v1);
        Node re1 = find(n1);
        Node n2 = map.get(v2);
        Node re2 = find(n2);

        //Ranking check
        if(re1==re2){
            re1.parent = re2;
            re2.rank++;
        }
        else if(re1.rank<re2.rank) re1.parent = re2;
        else re2.parent = re1;

    }

}
