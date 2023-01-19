import java.util.*;

class DiaPair{
    int ht = -1;
    int d = 0;
}

public class DiameterTree{
    //O(N^2) - Approach
    public static int height(TreeNode temp){
        if(temp==null) return -1;
        return (1+Math.max(height(temp.left), height(temp.right)));
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        //Base Case
        if(root==null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);
        //Diameters
        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        return Math.max(lh+rh+2, Math.max(ld,rd));
    }
    //O(N) Approach Using a Diameter Pair class for avoiding Revisit
    public DiaPair find_Dia(TreeNode root){
        //Base Case
        if(root==null) return new DiaPair();

        DiaPair ldp = find_Dia(root.left);
        DiaPair rdp = find_Dia(root.right);
        //New DiaPair
        DiaPair sdp = new DiaPair();

        int sd = ldp.ht + rdp.ht + 2;

        sdp.d = Math.max(ldp.d , Math.max(rdp.d, sd));
        sdp.ht = Math.max(ldp.ht,rdp.ht) +1 ;
        return sdp;
    }
    public static void main(String[] args) {
        DiameterTree obj = new DiameterTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree(root));
        System.out.println(obj.find_Dia(root).d);
    }
}