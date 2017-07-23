package Leetcode;

public class _606 {
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		String s = "";
		s += t.val;
		if (t.left == null && t.right == null) {
			return s;
		}

		s += "(" + tree2str(t.left) + ")";

		if (t.right != null) {
			s += "(" + tree2str(t.right) + ")";
		}
		return s;
	}
}
