package Leetcode;

public class _222 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		int n = 1;
		TreeNode cur = root;
		while (cur.left != null && cur.right != null) {
			if (isBigInLeftSub(cur)) {
				n *= 2;
				cur = cur.left;
			} else {
				n = n * 2 + 1;
				cur = cur.right;
			}
		}

		if (cur.left == null && cur.right == null) {
			return n;
		} else {
			return n = n * 2;
		}

	}

	public boolean isBigInLeftSub(TreeNode root) {
		TreeNode l = root.left;
		TreeNode r = root.right;
		int h = 0;
		while (l != null) {
			l = l.left;
			h++;
		}
		while (r != null) {
			r = r.left;
			h--;
		}

		if (h == 0) {
			return false;
		} else {
			return true;
		}
	}

	public int countNodes2(TreeNode root) {

		if (root == null)
			return 0;
		int l = 0;
		int r = 0;
		int n = 1;
		TreeNode cur = root;
		while (cur.left != null || cur.right != null) {
			l = height(cur);
			r = height(cur.right);
			if (l - r == 1) {
				cur = cur.right;
				n = n * 2 + 1;
			} else {
				cur = cur.left;
				n = n * 2;
			}
		}
		return n;
	}

	public int height(TreeNode n) {
		if (n == null)
			return 0;
		return 1 + height(n.left);
	}

}
