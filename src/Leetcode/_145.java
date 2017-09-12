package Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _145 {
	public List<Integer> postorderTraversal(TreeNode root) {
		//pre-order traversal is root-left-right, and post order is left-right-root. modify the code for pre-order to make it root-right-left,
		//and then reverse the output so that we can get 
		Stack<TreeNode> s = new Stack<TreeNode>();
		List<Integer> l = new ArrayList<Integer>();
		TreeNode cur = root;
		while (cur != null) {
			l.add(0, cur.val);
			s.add(cur);
			cur = cur.right;
		}

		while (!s.isEmpty()) {
			cur = s.pop();

			cur = cur.left;
			while (cur != null) {
				s.add(cur);
				l.add(0, cur.val);
				cur = cur.right;
			}
		}
		return l;
	}
}
