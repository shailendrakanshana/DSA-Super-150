public class printreverse {
    public static void revprint(int n){
        if(n==0){
            System.out.println("Forward");
            return ;
        }
        System.out.println(n);
        revprint(n-1);
        System.out.println(n);
    }
    public static int fact(int n,int r){
        if(n==0){
            return r;
        }
        return fact(n-1, r*n);
    }
    public static int power(int a,int b,int r){
        if(b==0){
            return r;
        }
        return power(a,b-1,r*a);
    }
    public static int findele(int ar[],int n,int e){
        if(n==-1){
            return -1;
        }
        if(ar[n-1]==e){
            return n-1;
        }
        return findele(ar, n-1, e);
        
    }

    public static void main(String[] args) {
        //revprint(5);
        System.out.println(fact(5,1));
        System.out.println(power(5, 4, 1));
        int ar[] = {1,2,3,4,5,6,7,8,9};
        System.out.println(findele(ar, ar.length, 6));
    }
    
}
