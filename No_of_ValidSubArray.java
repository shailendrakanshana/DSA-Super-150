// Given an array A of integers, return the number of non-empty continuous subarrays that satisfy the following condition:
// The leftmost element of the subarray is not larger than other elements in the subarray.
// Example 1:

// Input: [1,4,2,5,3]
// Output: 11
// Explanation: There are 11 valid subarrays: [1],[4],[2],[5],[3],[1,4],[2,5],[1,4,2],[2,5,3],[1,4,2,5],[1,4,2,5,3].



import java.util.Stack;

public class No_of_ValidSubArray {
    public static int find_ValidSubArray(int ar[]){
        Stack<Integer> stk = new Stack<>();
        int c = 0;
        for(int i = 0;i<ar.length;i++){
            while(!stk.isEmpty()&&ar[i]<stk.peek()){
                stk.pop();
            }
            stk.push(ar[i]);
            c = c + stk.size();
        }
        return c;
    }
    public static void main(String[] args) {
        int ar[] = {1,4,2,5,3};
        System.out.println(find_ValidSubArray(ar));
    }
}
