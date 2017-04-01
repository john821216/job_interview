package leetcode;

import java.util.Stack;

public class _101 {
	public boolean isSymmetric(TreeNode root) {
		return root == null || isSymmetricHelp(root.left, root.right);
	}

	public boolean isSymmetricHelp(TreeNode left, TreeNode right) {
		if (left == null && right == null)
			return true;
		if (left == null || right == null)
			return false;

		if (left.val != right.val)
			return false;
		if (!isSymmetricHelp(left.left, right.right)
				|| !isSymmetricHelp(left.right, right.left)) {
			return false;
		}
		return true;
	}

	public boolean isSymmetric2(TreeNode root) {

		if (root == null)
			return true;
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root.left == null && root.right == null)
			return true;
		if (root.left == null || root.right == null)
			return false;
		if (root.left.val != root.right.val)
			return false;

		s.add(root.left);
		s.add(root.right);

		while (!s.isEmpty()) {
			TreeNode right = s.pop();
			TreeNode left = s.pop();

			if (left.left == null) {
				if (right.right != null) {
					System.out.println("28");
					return false;
				}
			}

			if (left.left != null) {
				if (right.right != null) {
					if (left.left.val == right.right.val) {
						s.add(left.left);
						s.add(right.right);
					} else {
						System.out.println("39");
						return false;
					}
				} else {
					System.out.println("43");
					return false;
				}
			}

			if (left.right == null) {
				if (right.left != null) {
					System.out.println("50");

					return false;
				}
			}

			if (left.right != null) {
				if (right.left != null) {
					System.out.println("58");
					if (left.right.val == right.left.val) {
						s.add(left.right);
						s.add(right.left);
					} else {
						System.out.println("62");

						return false;
					}
				} else {
					System.out.println("67");

					return false;
				}
			}
		}
		return true;
	}
}
