public class lexcoSort {
    public static void lexSort(int curr,int n){
        if(curr>n){
            return;
        }
        else{
            System.out.println(curr);
            for(int i=0;i<10;++i){
                if(10*curr+i>n)
                    return;
                lexSort(10*curr+i, n);
            }
        }
    }
    public static void main(String[] args) {
        for(int i = 1;i<10;i++){
            lexSort(i, 1000);
        }
    }
    
}
