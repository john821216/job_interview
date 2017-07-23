package Leetcode;

public class _623 {
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		if (d == 1) {
			TreeNode r = new TreeNode(v);
			r.left = root;
			return r;
		}
		return addOneRowHelper(root, v, d, 1);
	}

	public TreeNode addOneRowHelper(TreeNode root, int v, int d, int dep) {
		if (root == null) {
			return null;
		}
		if (dep == d - 1) {
			TreeNode r = new TreeNode(root.val);
			TreeNode left = root.left;
			TreeNode right = root.right;
			if (left != null) {
				r.left = new TreeNode(v);
				r.left.left = left;
			} else {
				r.left = new TreeNode(v);
			}

			if (right != null) {
				r.right = new TreeNode(v);
				r.right.right = right;
			} else {
				r.right = new TreeNode(v);
			}
			return r;
		}

		if (d - 1 > dep) {
			TreeNode r = new TreeNode(root.val);
			r.left = addOneRowHelper(root.left, v, d, dep + 1);
			r.right = addOneRowHelper(root.right, v, d, dep + 1);
			return r;
		}
		return null;
	}	
}
