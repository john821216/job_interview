package Leetcode;

import java.util.Stack;

public class _572 {
	public boolean isSubtree(TreeNode s, TreeNode t) {
		int target = t.val;
		TreeNode cur = null;
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.add(s);
		while (!st.isEmpty()) {
			TreeNode pop = st.pop();
			if (pop.val == target) {
				cur = pop;
				if (isSameTree(cur, t) == true) {
					return true;
				}
			}
			if (pop.left != null)
				st.add(pop.left);
			if (pop.right != null)
				st.add(pop.right);

		}
		return false;
	}

	public boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) {
			return true;
		}

		if (s != null && t == null) {
			return false;
		}

		if (s == null && t != null) {
			return false;
		}

		if (s.val != t.val) {
			return false;
		}
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
