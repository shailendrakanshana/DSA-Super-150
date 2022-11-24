import java.util.Scanner;

public class Permutations {
    public static void permutations(String s,String ans){
        if(s.length()==0){
            System.out.println(ans+" ");
        }
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            boolean b = false;
            /*String r = s.substring(0, i)+s.substring(i+1);
            permutations(r, ans+c);*/
            for(int j =i+1;j<s.length();j++){
                if(s.charAt(j)==c){
                    b = true;
                    break;
                }
            }
            if(!b){
                String r = s.substring(0, i)+s.substring(i+1);
                permutations(r, ans+c);
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        permutations(sc.next(),"");
    }
    
}
