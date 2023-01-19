public class DiameterTree{
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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree(root));
    }
}