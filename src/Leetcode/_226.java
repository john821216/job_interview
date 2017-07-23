package Leetcode;

import java.util.Stack;

public class _226 {
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}

		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);
		return root;
	}

	// iterative
	public TreeNode invertTree2(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		if (root == null) {
			return null;
		}

		s.add(root);
		while (!s.isEmpty()) {
			TreeNode n = s.pop();

			TreeNode temp = n.left;
			n.left = n.right;
			n.right = temp;
			if (n.left != null) {
				s.add(n.left);
			}
			if (n.right != null) {
				s.add(n.right);
			}
		}
		return root;
	}
}
