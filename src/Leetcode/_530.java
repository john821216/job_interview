package Leetcode;

public class _530 {
	int min = Integer.MAX_VALUE;
	boolean hasPre = false;
	int pre = 0;

	public int getMinimumDifference(TreeNode root) {
		if (root.left != null) {
			getMinimumDifference(root.left);
		}
		if (!hasPre) {
			hasPre = true;
		} else {
			min = Math.min(root.val - pre, min);
		}
		pre = root.val;

		if (root.right != null) {
			getMinimumDifference(root.right);
		}
		return min;
	}
}
