package Leetcode;

public class _124 {
	int maxValue;

	public int maxPathSum(TreeNode root) {
		maxValue = Integer.MIN_VALUE;
		find(root);
		return maxValue;
	}

	public int find(TreeNode n) {
		if (n == null) {
			return 0;
		}
		int left = Math.max(0, find(n.left));
		int right = Math.max(0, find(n.right));
		maxValue = Math.max(maxValue, left + right + n.val);
		return Math.max(left, right) + n.val;
	}
}
