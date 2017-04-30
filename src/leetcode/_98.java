package Leetcode;

public class _98 {
	public boolean isValidBST(TreeNode root) {
		return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean isValidBSTHelper(TreeNode n, int min, int max) {
		if (n == null) {
			return true;
		}
		if (n.val < min || n.val > max) {
			return false;
		}
		return isValidBSTHelper(n.left, min, n.val)
				&& isValidBSTHelper(n.right, n.val, max);
	}
}
