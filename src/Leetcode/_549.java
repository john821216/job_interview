package Leetcode;

public class _549 {
	int globalMax = 0;

	public int longestConsecutive(TreeNode root) {
		longestConsecutiveHelper(root);
		return globalMax;
	}

	public int longestConsecutiveHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = longestConsecutiveHelper(root.left);
		int right = longestConsecutiveHelper(root.right);
		int cur = 1;
		boolean leftOk = false;
		boolean rightOk = false;
		if (root.left != null) {
			if (root.val == root.left.val + 1) {
				cur += left;
				leftOk = true;

				if (root.right != null) {
					if (root.val + 1 == root.right.val) {
						cur += right;
						rightOk = true;
					}
				}
			} else {
				if (root.val + 1 == root.left.val) {
					cur += left;
					leftOk = true;
				}
				if (root.right != null) {
					if (root.val == root.right.val + 1) {
						cur += right;
						rightOk = true;
					}
				}
			}
		}

		if (root.right != null) {
			if (root.val == root.right.val + 1) {
				cur += right;
				rightOk = true;
			}

			if (root.val + 1 == root.right.val) {
				cur += right;
				rightOk = true;
			}
		}
		globalMax = Math.max(cur, globalMax);

		int re = 0;
		if (leftOk) {
			re = left;
		}
		if (rightOk) {
			re = Math.max(re, right);
		}
		return re + 1;
	}
}
