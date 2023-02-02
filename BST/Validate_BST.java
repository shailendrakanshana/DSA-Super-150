import java.util.*;

public class Validate_BST {
     //Using Stack 
     public boolean isValidBST(TreeNode root) {
        if(root==null) return true;
        Stack<TreeNode> s = new Stack<>();
        Double leftval = -Double.MAX_VALUE;
        while(!s.isEmpty() || root!=null){
            //Putting all left nodes
            while(root!=null){
                s.push(root);
                root = root.left;
            }
            //Checking left child
            root = s.pop();
            if(root.val<=leftval) return false;
            //Updating values
            leftval = (double)root.val;
            root = root.right;
        }
        
        return true;
    }
}
