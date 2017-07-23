package Leetcode;

public class _235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		while((root.val - p.val) * (root.val-q.val) > 0 ){
			if(p.val < root.val){
				root = root.left;
			} else if(p.val > root.val){
				root = root.right;
			}
		}
		return root;
	}
}
