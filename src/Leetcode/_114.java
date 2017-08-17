package Leetcode;

public class _114 {
	private TreeNode last = null;

	public void flatten(TreeNode root) {
		if (root == null) {
			return;
		}
		if (last != null) {
			last.right = root;
			last.left = null;
		}
		last = root;
		TreeNode right = root.right;
		if (root.left != null) {
			flatten(root.left);
		}
		if (right != null) {
			flatten(right);
		}
	}
}
