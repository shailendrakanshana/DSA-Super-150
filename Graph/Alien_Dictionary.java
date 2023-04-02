import java.util.*;

public class Alien_Dictionary {
    public String alien_Dict(String ar[]){
        HashMap<Character,List<Character>> map = new HashMap<>();
        for(int i = 0;i<ar.length;i++){
            String s = ar[i];
            for(int j  =0;j<s.length();j++){
                if(!map.containsKey(s.charAt(j))){
                    map.put(s.charAt(j),new ArrayList<>());
                }
            }
        }
        //Loop for generating Directed graph
        for(int i = 0;i<ar.length-1;i++){
            String s1 = ar[i];
            String s2 = ar[i+1];
            //Condition to handle Not possible grammer condition like ['abc','ab'] is not possible
            if(s1.startsWith(s2) && ( s1.length() > s2.length())) return "";

            for(int j = 0;j<Math.min(s1.length(),s2.length());j++){
                if(s1.charAt(j)!=s2.charAt(j)){
                    map.get(s1.charAt(j)).add(s2.charAt(j));
                    break;
                }
            }
        }
        return TopologicalSort(map);

    }
    // Indegree 
    public int[] Indegre(HashMap<Character,List<Character>> map){
        int ar[] = new int[26];
        for(char key:map.keySet()){
            for(char nbrs:map.get(key)){
                ar[nbrs-'a']++;
            }
        }
        return ar;
    }
    //Topological Sort
    public String TopologicalSort(HashMap<Character,List<Character>> map){
        int ar[] = Indegre(map);
        Queue<Character> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c:map.keySet()){
            if(ar[c-'a']==0) q.add(c);
        }
        int count = 0;
        while(!q.isEmpty()){
            char c = q.poll();
            count++;
            sb.append(c);
            for(char nbrs:map.get(c)){
                ar[nbrs-'a']--;
                if(ar[nbrs-'a']==0) q.add(nbrs);
            }
        }
        if(count==map.size()) return sb.toString();
        return "";
    }
    public static void main(String[] args) {
        Alien_Dictionary obj = new Alien_Dictionary();
        String ar[]  = {"wrt","wrf","er","ett","rftt"};
        System.out.println(obj.alien_Dict(ar));
    }
}
