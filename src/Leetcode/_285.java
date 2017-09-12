package Leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _285 {
	public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		TreeNode cur = root;
		boolean findCur = false;
		while (cur != null) {
			s.add(cur);
			cur = cur.left;
		}
		while (!s.isEmpty()) {
			TreeNode pop = s.pop();
			if (pop.val == p.val) {
				findCur = true;
			} else if (findCur) {
				return pop;
			}

			if (pop.right != null) {
				TreeNode c = pop.right;
				while (c != null) {
					s.add(c);
					c = c.left;
				}
			}
		}
		return null;
	}
}
