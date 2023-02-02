public class BST_Camera {
    int ans = 0;
    public int find_Count(TreeNode root){
        if(root==null) return 1;
        int left = find_Count(root.left);
        int right = find_Count(root.right);
        if(left==-1 || right==-1){
            ans++;
            return 2;
        }
        if(left==1 && right==1) return -1;
        else return 1;

    }
    public int minCameraCover(TreeNode root) {
        int c = find_Count(root);
        if(c==-1) ans++;
        return ans;        
    }
}
