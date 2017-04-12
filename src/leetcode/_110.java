package leetcode;

public class _110 {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		int leftDepth = nodeDepth(root.left);
		int rightDepth = nodeDepth(root.right);
		return Math.abs(leftDepth - rightDepth) <= 1 && isBalanced(root.left)
				&& isBalanced(root.right);
	}

	public int nodeDepth(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(nodeDepth(root.left), nodeDepth(root.right)) + 1;
	}

	public boolean isBalanced2(TreeNode root) {
		if (nodeDepth2(root) != -1) {
			return true;
		} else {
			return false;
		}
	}

	public int nodeDepth2(TreeNode n) {
		if (n == null)
			return 0;
		int leftDepth = nodeDepth2(n.left);
		if (leftDepth == -1)
			return -1;

		int rightDepth = nodeDepth(n.right);
		if (rightDepth == -1)
			return -1;
		if (Math.abs(leftDepth - rightDepth) <= 1) {
			return Math.max(leftDepth, rightDepth) + 1;
		} else {
			return -1;
		}

	}
}
