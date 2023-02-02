class BSTPair{
    boolean isBST = true;
    long min = Long.MAX_VALUE;
    long max = Long.MIN_VALUE;
}

public class Validate_BST_CLASS {
    public BSTPair isValidBST(TreeNode root){
        BSTPair lbp = isValidBST(root.left);
        BSTPair rbp = isValidBST(root.right);
        //Creating new 
        BSTPair sbp = new BSTPair();
        sbp.max = Math.max(lbp.max,Math.max(rbp.max,root.val));
        sbp.min = Math.min(lbp.min,Math.min(rbp.min,root.val));
        if(lbp.max<root.val && rbp.min>root.val && lbp.isBST && rbp.isBST) sbp.isBST = true;
        else sbp.isBST = false;
        return sbp;
    }
    
}
