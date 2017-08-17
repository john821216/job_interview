package Leetcode;

public class _99 {
	private TreeNode first = null;
	private TreeNode second = null;
	private TreeNode pre = null;

	public void recoverTree(TreeNode root) {
		recoverTreeHelper(root);
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}

	public void recoverTreeHelper(TreeNode root) {
		if (root == null) {
			return;
		}
		recoverTreeHelper(root.left);
		// find peak;
		if (pre != null) {
			if (first == null && pre.val > root.val) {
				first = pre;
			} else if(first != null && pre.val > root.val) {
				second = root;
			}
		}
		pre = root;
		recoverTreeHelper(root.right);

	}
}
