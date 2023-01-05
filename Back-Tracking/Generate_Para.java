public class Generate_Para {
    public static void generate(String ans,int o,int c,int n){
        if(o==n && c==n){
            System.out.println(ans);
            return;
        }
        if(c<o) generate(ans+"]", o, c+1, n);
        if(o<n) generate(ans+"[", o+1, c, n);

    }
    public static void main(String[] args) {
        generate("", 0, 0, 3);
    }
}
