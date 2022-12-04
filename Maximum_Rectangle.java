import java.util.*;

public class Maximum_Rectangle {
    public static int Find_Largest(int ar[]){
        Stack<Integer> s = new Stack<>();
        int max = 0;
        for(int i = 0;i<ar.length;i++){
            while(!s.isEmpty() && ar[i]<ar[s.peek()]){
                int h = ar[s.pop()];
                int r = i;
                if(s.isEmpty()) max = Math.max(max,h*r);
                else{
                    int l = s.peek();
                    max = Math.max(max,(r-l-1)*h);
                }
                
            }
            s.push(i);
        }
        int r = ar.length;
        while(!s.isEmpty()){
            int h = ar[s.pop()];
            if(s.isEmpty()){
                max = Math.max(max,h*r);
            }
            else {
                int l = s.peek();
                max = Math.max(max,h*(r-l-1));
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int ans[] = new int[matrix[0].length];
        int area = 0;
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j]==1){
                    ans[j]++;
                }
                else{
                    ans[j] = 0;
                }
            }
            area = Math.max(area,Find_Largest(ans));
        }
        System.out.print(area);
    }
    
}
