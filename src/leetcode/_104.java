package leetcode;

public class _104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return maxDepthHelp(root, 1);
    }
    
    public int maxDepthHelp(TreeNode n, int depth){
        if(n == null) return depth-1;
        int leftDepth = maxDepthHelp(n.left, depth+1);
        int rightDepth = maxDepthHelp(n.right, depth+1);
        if(leftDepth > rightDepth){
            return leftDepth;
        } else{
            return rightDepth;
        }
    }
    
    public int maxDepth2(TreeNode root){
    		if(root == null) return 0;
    		return 1+ Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
