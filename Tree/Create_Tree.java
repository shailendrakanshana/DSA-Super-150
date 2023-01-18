import java.util.Scanner;

public class Create_Tree {
    public static TreeNode createTree(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Value : ");
        int a = sc.nextInt();
        TreeNode root = new TreeNode(a);
        System.out.print("Has left child ? : ");
        boolean hlc = sc.nextBoolean();
        if(hlc) root.left = createTree();
        System.out.print("Has right child ? : ");
        boolean hrc = sc.nextBoolean();
        if(hrc) root.right = createTree();
        sc.close();
        return root;
    }
    public static void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        TreeNode root = createTree();
        inorder(root);
    }
}
