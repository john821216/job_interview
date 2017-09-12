package Leetcode;

public class _250 {
	int count = 0;

	public int countUnivalSubtrees(TreeNode root) {
		if (root == null) {
			return 0;
		}
		countUnivalSubtrees(root, root.val);
		return count;
	}

	public boolean countUnivalSubtrees(TreeNode root, int preNum) {
		if (root == null) {
			return true;
		}
		boolean left = countUnivalSubtrees(root.left, root.val);
		boolean right = countUnivalSubtrees(root.right, root.val);
		if (left == true && right == true) {
			count++;
		}
		return preNum == root.val && left == true && right == true;
	}
}
