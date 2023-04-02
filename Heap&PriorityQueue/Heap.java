import java.util.*;

public class Heap{
    private ArrayList<Integer> data = new ArrayList<>();

    public void add(int a){
        data.add(a);
        upheapify(data.size()-1);
    }

    private void upheapify(int child_index){
        int parent_index = (child_index-1)/2;
        //Creating min head property
        if(data.get(parent_index)>data.get(child_index)){
            swap(parent_index,child_index);
        } 
    }
    private void swap(int a,int b){
        
    }

    // private ArrayList<Integer> list = new ArrayList<>();
    // public void add(int x){
    //     list.add(x);
    //     upheapify(list.size()-1);
    // }
    // private void upheapify(int ci){
    //     int pi = (ci-1)/2;
    //     //Swapping based on min heap property
    //     if(list.get(pi)>list.get(ci)){
    //         swap(ci,pi);
    //         upheapify(pi);
    //     } 

    // }
    // public void swap(int a,int b){
    //     int temp = list.get(a);
    //     int cemp = list.get(b);
    //     list.set(a,cemp);
    //     list.set(b,temp);
    // }
    // public void downHeapify(int pi){
    //     int lci = 2*pi+1;
    //     int rci = 2*pi+2;
    //     int mini = pi;
    //     if(lci<list.size() && list.get(mini)>list.get(lci)) mini = lci;
    //     if(rci<list.size() && list.get(mini)>list.get(rci)) mini = rci;

    //     if(mini!=pi){
    //         swap(pi, mini);
    //         downHeapify(mini);
    //     }
    // }
    // public int min(){
    //     return list.get(0);
    // }
    // public int size(){
    //     return list.size();
    // }
    // public void display(){
    //     System.out.println(list);
    // }

}
