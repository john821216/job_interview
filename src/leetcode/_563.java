package Leetcode;

public class _563 {
	int dif = 0;

	public int findTilt(TreeNode root) {
		if (root == null)
			return 0;
		findTiltHelper(root);
		return dif;
	}

	public int findTiltHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = findTiltHelper(root.left);
		int right = findTiltHelper(root.right);
		dif += Math.abs(left - right);
		return left + right + root.val;
	}
}
