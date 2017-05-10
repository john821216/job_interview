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

	TreeNode min = null;

	public boolean isValidBST2(TreeNode root) {
		boolean ok = true;
		if (root == null) return true;
		if (root.left != null) ok &= isValidBST2(root.left);
			

		if (min == null) {
			min = root;
		} else {
			if (min.val >= root.val) {
				return false;
			} else {
				min = root;
			}
		}

		if (root.right != null) ok &= isValidBST2(root.right);
		return ok;
	}
}
