package Leetcode;

public class _333 {
	int maxSize = 0;

	public int largestBSTSubtree(TreeNode root) {
		largestBSTSubtreeHelper(root);
		return maxSize;
	}

	public Integer[] largestBSTSubtreeHelper(TreeNode root) {
		if (root == null) {
			return new Integer[] { 0, null, null };
		}

		Integer[] left = largestBSTSubtreeHelper(root.left);
		Integer[] right = largestBSTSubtreeHelper(root.right);

		if (left[0] == -1 || right[0] == -1) {
			return new Integer[] { -1, null, null };
		}
		Integer[] i = new Integer[3];
		int totalSize = 0;
		if (root.left != null) {
			if (root.val > root.left.val) {
				if (left[2] != null && left[2] > root.val) {
					return new Integer[] { -1, null, null };
				}
				if (left[1] == null) {
					i[1] = root.left.val;
				} else {
					i[1] = left[1];
				}
				totalSize += left[0];
			} else {
				return new Integer[] { -1, null, null };
			}
		}

		if (root.right != null) {
			if (root.val < root.right.val) {
				if (right[1] != null && right[1] < root.val) {
					return new Integer[] { -1, null, null };
				}
				if (right[2] == null) {
					i[2] = root.right.val;
				} else {
					i[2] = left[2];
				}
				totalSize += right[0];
			} else {
				return new Integer[] { -1, null, null };
			}
		}
		i[0] = totalSize + 1;
		maxSize = Math.max(maxSize, totalSize + 1);
		return i;
	}
}
