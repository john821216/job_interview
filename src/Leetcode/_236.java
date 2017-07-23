package Leetcode;

public class _236 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == p || root == q) {
			return root;
		}

		boolean isPLeft = find(root.left, p);
		boolean isQLeft = find(root.left, q);
		if ((isPLeft && !isQLeft || (!isPLeft && isQLeft))) {
			return root;
		}

		if (isPLeft && isQLeft) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return lowestCommonAncestor(root.right, p, q);
		}
	}

	public boolean find(TreeNode root, TreeNode p) {
		if (root == null) {
			return false;
		}
		if (root == p) {
			return true;
		}
		return find(root.left, p) || find(root.right, p);
	}

	public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null) {
			return null;
		}

		if (root == p || root == q) {
			return root;
		}

		TreeNode left = lowestCommonAncestor2(root.left, p, q);
		TreeNode right = lowestCommonAncestor2(root.right, p, q);
		if (left != null && right != null) {
			return root;
		} else {
			if (left == null) {
				return right;
			} else {
				return left;
			}
		}

	}

}
