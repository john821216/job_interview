package Leetcode;

public class _617 {
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		if (t1 == null && t2 == null) {
			return null;
		}
		TreeNode root = new TreeNode(0);
		TreeNode t1left = null;
		TreeNode t1right = null;
		TreeNode t2left = null;
		TreeNode t2right = null;
		if (t1 != null) {
			root.val += t1.val;
			t1left = t1.left;
			t1right = t1.right;
		}

		if (t2 != null) {
			root.val += t2.val;
			t2left = t2.left;
			t2right = t2.right;
		}
		root.left = mergeTrees(t1left, t2left);
		root.right = mergeTrees(t1right, t2right);
		return root;
	}
}
