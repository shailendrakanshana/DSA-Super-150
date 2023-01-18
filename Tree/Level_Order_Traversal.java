// IMPORTANT = (BFS , LOT = Queue)

public class Level_Order_Traversal {
    //Brute force approach - Printing LevelWise
    public static void printLevel(TreeNode root,int level){
        if(root==null) return;
        if(level==1) System.out.print(root.val+" ");
        else{
            printLevel(root.left, level-1);
            printLevel(root.right, level-1);
        }
    }
    //function for Height
    public static int height(TreeNode root){
        if(root==null) return 0;
        return 1 + Math.max(height(root.left),height(root.right));
    }
    //Main loop to print
    public static void BLOT(TreeNode root){
        int n = height(root);
        for(int i = 1;i<=n;i++){
            printLevel(root, i);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BLOT(root);
    }
}
