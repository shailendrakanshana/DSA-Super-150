public class SumToLeaf {
    int sum;
    public void getnum(TreeNode root,int r){
        if(root==null) return;
        if(root.left==null && root.right==null){
            r = r*10 + root.val;
            sum = sum + r;
            return;
        }
        getnum(root.left,(r*10)+root.val);
        getnum(root.right,(r*10)+root.val);
    }
    public int sumNumbers(TreeNode root) {
        sum = 0;
        getnum(root,0);
        return sum;
    }
    public static void main(String[] args) {
        SumToLeaf obj = new SumToLeaf();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(obj.sumNumbers(root));
    }
}
